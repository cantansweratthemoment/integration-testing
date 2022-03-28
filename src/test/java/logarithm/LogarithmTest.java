package logarithm;

import functions.logarithm.Ln;
import functions.logarithm.Log;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import util.CsvPrinter;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogarithmTest {
    private final Double accuracy = 0.0001;
    private final Ln ln = new Ln();
    private final Log log = new Log();
    private final CsvPrinter csvPrinter = new CsvPrinter();

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmMocks/ln.csv")
    void lnTest(Double x, BigDecimal expected) throws FileNotFoundException {
        try {
            BigDecimal result = ln.calculate(x, accuracy);
            csvPrinter.setFilePath("src/test/resources/output/ln.csv");
            csvPrinter.print(x, result.doubleValue());
            assertEquals(expected.floatValue(), result.floatValue(), 0.1);
        } catch (ArithmeticException e) {
            assertEquals("x is less than or equals to 0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmMocks/log.csv")
    void logTest(Double x, Double base, BigDecimal expected) throws FileNotFoundException {
        try {
            BigDecimal result = log.calculate(x, accuracy, base);
            csvPrinter.setFilePath("src/test/resources/output/log.csv");
            csvPrinter.print(x, result.doubleValue());
            assertEquals(expected.floatValue(), result.floatValue(), 0.1);
        } catch (ArithmeticException e) {
            assertEquals("x is less than or equals to 0", e.getMessage());
        }
    }
}