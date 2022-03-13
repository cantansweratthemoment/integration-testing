package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sec {
    Cos cos = new Cos();

    public BigDecimal calculate(double x, double eps) {
        return new BigDecimal(1).divide(cos.calculateCos(x, eps), 20, RoundingMode.HALF_UP);
    }
}
