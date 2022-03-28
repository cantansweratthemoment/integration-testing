package trigonometry;

import functions.trigonometry.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import util.CsvPrinter;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometryTest {
    private final Double accuracy = 0.0001;
    private final Cos cos = new Cos();
    private final Cot cot = new Cot();
    private final Csc csc = new Csc();
    private final Sec sec = new Sec();
    private final Sin sin = new Sin();
    private final Tan tan = new Tan();
    private final CsvPrinter csvPrinter = new CsvPrinter();

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/cos.csv")
    void cosTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = cos.calculateCos(x, accuracy);
        csvPrinter.setFilePath("src/test/resources/output/cos.csv");
        csvPrinter.print(x, result.doubleValue());
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/cot.csv")
    void cotTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = cot.calculate(x, accuracy);
        csvPrinter.setFilePath("src/test/resources/output/cot.csv");
        csvPrinter.print(x, result.doubleValue());
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/csc.csv")
    void cscTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = csc.calculate(x, accuracy);
        csvPrinter.setFilePath("src/test/resources/output/csc.csv");
        csvPrinter.print(x, result.doubleValue());
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/sec.csv")
    void secTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = sec.calculate(x, accuracy);
        csvPrinter.setFilePath("src/test/resources/output/sec.csv");
        csvPrinter.print(x, result.doubleValue());
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/sin.csv")
    void sinTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = sin.calculateSin(x, accuracy);
        csvPrinter.setFilePath("src/test/resources/output/sin.csv");
        csvPrinter.print(x, result.doubleValue());
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometryMocks/tan.csv")
    void tanTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = tan.calculate(x, accuracy);
        csvPrinter.setFilePath("src/test/resources/output/tan.csv");
        csvPrinter.print(x, result.doubleValue());
        assertEquals(expected.floatValue(), result.floatValue(), accuracy);
    }
}
