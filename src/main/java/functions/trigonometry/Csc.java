package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Csc {
    Sin sin = new Sin();

    public BigDecimal calculate(double x, double eps) {
        return new BigDecimal(1).divide(sin.calculateSin(x, eps), 20, RoundingMode.HALF_UP);
    }
}
