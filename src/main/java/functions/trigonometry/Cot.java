package functions.trigonometry;

import functions.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cot {
    Sin sin = new Sin();
    Cos cos = new Cos();

    public BigDecimal calculate(double x, double eps) {
        return cos.calculateCos(x, eps).divide(sin.calculateSin(x, eps),20, RoundingMode.HALF_UP);
    }
}
