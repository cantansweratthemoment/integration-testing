package functions.trigonometry;

import java.math.BigDecimal;
import java.math.MathContext;

public class Cos {
    Sin sin = new Sin();

    public BigDecimal calculateCos(double x, double eps) {
        BigDecimal cos = new BigDecimal(1);
        cos = cos.subtract(sin.calculateSin(x, eps).pow(2)).sqrt(MathContext.DECIMAL128);
        return cos;
    }
}
