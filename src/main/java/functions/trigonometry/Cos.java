package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static functions.trigonometry.Fac.calculateFactorial;

public class Cos {
    /*
   oo
   ---
   \     (-1)^n * x^(2n)
   /    ------------------       <---- это ряд Тейлора cos(x)
   ---      (2*n)!
   n=0
 */
    public BigDecimal calculateCos(double x, int eps) {
        BigDecimal cos = new BigDecimal(0);
        for (int n = 0; n < 900; n++) {
            cos = cos.add(new BigDecimal(-1).pow(n).multiply(new BigDecimal(x).pow(2 * n)).divide(new BigDecimal(calculateFactorial(2 * n)), eps, RoundingMode.HALF_UP));
        }
        return cos;
    }
}
