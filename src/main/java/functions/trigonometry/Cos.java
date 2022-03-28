package functions.trigonometry;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Cos {
    Sin sin = new Sin();

    public BigDecimal calculateCos(double x, double eps) {
        BigDecimal cos = new BigDecimal(1);
        cos = cos.subtract(sin.calculateSin(x, eps).pow(2)).sqrt(MathContext.DECIMAL128);
        x = abs(x % (2 * PI));
        if ((x > PI / 2) && (x <3 * PI / 2)) {
            cos = cos.multiply(BigDecimal.valueOf(-1));
        }
        return cos;
    }
}
