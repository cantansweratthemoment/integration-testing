package functions.trigonometry;

import functions.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.PI;

public class Sec {
    Cos cos = new Cos();

    public Number calculate(double x, int eps) {
        if ((((x % (2 * PI)) + PI) == PI)) {
            return new Number(null, true);
        }
        return new Number(new BigDecimal(1).divide(cos.calculateCos(x, eps), eps, RoundingMode.HALF_UP), false);
    }
}
