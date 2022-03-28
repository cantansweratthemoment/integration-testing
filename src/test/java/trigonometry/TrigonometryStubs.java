package trigonometry;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import functions.function.Trigonometry;
import functions.trigonometry.*;
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

public class TrigonometryStubs {
    private static final Double accuracy = 0.01;
    private static final Cos cos = mock(Cos.class);
    private static final Cot cot = mock(Cot.class);
    private static final Csc csc = mock(Csc.class);
    private static final Sec sec = mock(Sec.class);
    private static final Sin sin = mock(Sin.class);
    private static final Tan tan = mock(Tan.class);
    public static final Trigonometry trigonometry = null;

    private static void getCosMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigonometryMocks/cos.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.cos.calculateCos(Double.parseDouble(record[0]), accuracy)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getCotMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigonometryMocks/cot.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.cot.calculate(Double.parseDouble(record[0]), accuracy)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getCscMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigonometryMocks/csc.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.csc.calculate(Double.parseDouble(record[0]), accuracy)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getSecMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigonometryMocks/sec.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.sec.calculate(Double.parseDouble(record[0]), accuracy)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getSinMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigonometryMocks/sin.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.sin.calculateSin(Double.parseDouble(record[0]), accuracy)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getTanMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/trigonometryMocks/tan.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.tan.calculate(Double.parseDouble(record[0]), accuracy)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    @BeforeAll
    public static void fillMocks() throws IOException, CsvException {
        getCosMockDataFromCsv();
        getCotMockDataFromCsv();
        getCscMockDataFromCsv();
        getSecMockDataFromCsv();
        getSinMockDataFromCsv();
        getTanMockDataFromCsv();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/cos.csv")
    void cosTest(Double x, BigDecimal expected) {
        BigDecimal result = cos.calculateCos(x, accuracy);
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/cot.csv")
    void cotTest(Double x, BigDecimal expected) {
        BigDecimal result = cot.calculate(x, accuracy);
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/csc.csv")
    void cscTest(Double x, BigDecimal expected) {
        BigDecimal result = csc.calculate(x, accuracy);
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/sec.csv")
    void secTest(Double x, BigDecimal expected) {
        BigDecimal result = sec.calculate(x, accuracy);
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/sin.csv")
    void sinTest(Double x, BigDecimal expected) {
        BigDecimal result = sin.calculateSin(x, accuracy);
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/tan.csv")
    void tanTest(Double x, BigDecimal expected) {
        BigDecimal result = tan.calculate(x, accuracy);
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }
}
