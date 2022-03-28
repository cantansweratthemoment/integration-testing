import com.opencsv.exceptions.CsvException;
import functions.function.Logarithm;
import functions.function.Trigonometry;
import logarithm.LogarithmStubs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigonometry.TrigonometryStubs;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Function Test")
public class FunctionTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/function.csv")
    void allMock(Double x, Double trueResult) throws IOException, CsvException {
        LogarithmStubs.fillMocks();
        TrigonometryStubs.fillMocks();
        Function function = new Function(LogarithmStubs.logarithm, TrigonometryStubs.trigonometry);
        BigDecimal result = function.calculate(x);
        assertEquals(trueResult, result.doubleValue(), 0.1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function.csv")
    void noneMock(Double x, Double trueResult) {
        Function function = new Function(new Logarithm(x, 0.001), new Trigonometry(x, 0.001));
        BigDecimal result = function.calculate(x);
        assertEquals(trueResult, result.doubleValue(), 0.1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function.csv")
    void logarithmMock(Double x, Double trueResult) throws IOException, CsvException {
        LogarithmStubs.fillMocks();
        Function function = new Function(LogarithmStubs.logarithm, new Trigonometry(x, 0.01));
        BigDecimal result = function.calculate(x);
        assertEquals(trueResult, result.doubleValue(), 10000000.0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function.csv")
    void trigonometryMock(Double x, Double trueResult) throws IOException, CsvException {
        TrigonometryStubs.fillMocks();
        Function function = new Function(new Logarithm(x, 0.01),TrigonometryStubs.trigonometry);
        BigDecimal result = function.calculate(x);
        assertEquals(trueResult, result.doubleValue(), 0.1);
    }
}
