package logarithm;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import functions.function.Logarithm;
import functions.logarithm.Ln;
import functions.logarithm.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogarithmStubs {
    private static final Double accuracy = 0.01;
    private static final Ln ln = mock(Ln.class);
    private static final Log log = mock(Log.class);
    public static final Logarithm logarithm = null;

    private static void getLnMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/logarithmMocks/ln.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(LogarithmStubs.ln.calculate(Double.parseDouble(record[0]), accuracy)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getLogMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/logarithmMocks/log.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(LogarithmStubs.log.calculate(Double.parseDouble(record[0]), accuracy, Double.parseDouble(record[1]))).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[2])));
            }
        }
    }

    @BeforeAll
    public static void fillMocks() throws IOException, CsvException {
        getLnMockDataFromCsv();
        getLogMockDataFromCsv();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmMocks/ln.csv")
    void lnTest(Double x, BigDecimal expected) {
        try {
            BigDecimal result = ln.calculate(x, accuracy);
            assertEquals(expected.floatValue(), result.floatValue(), accuracy);
        } catch (ArithmeticException e) {
            assertEquals("x is less than or equals to 0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmMocks/log.csv")
    void logTest(Double x, Double base, BigDecimal expected) {
        try {
            BigDecimal result = log.calculate(x, accuracy, base);
            assertEquals(expected.floatValue(), result.floatValue(), accuracy);
        } catch (ArithmeticException e) {
            assertEquals("x is less than or equals to 0", e.getMessage());
        }
    }
}
