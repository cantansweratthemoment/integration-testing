package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tan {
    Sin sin = new Sin();
    Cos cos = new Cos();

    public BigDecimal calculate(double x, double eps) {
        return sin.calculateSin(x, eps).divide(cos.calculateCos(x, eps), 20, RoundingMode.HALF_UP);
    }

}
