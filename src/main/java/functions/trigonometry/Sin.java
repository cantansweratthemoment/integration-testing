package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static functions.trigonometry.Fac.calculateFactorial;

public class Sin {
    /*
       oo
       ---
       \     (-1)^n * x^(2n+1)
       /    ------------------          <---- это ряд Тейлора sin(x)
       ---      (2*n+1)!
       n=0
     */
    public BigDecimal calculateSin(double x, int eps) {
        BigDecimal sin = new BigDecimal(0);
        for (int n = 0; n < 900; n++) {
            sin = sin.add(new BigDecimal(-1).pow(n).multiply(new BigDecimal(x).pow(2 * n + 1)).divide(new BigDecimal(calculateFactorial(2 * n + 1)), eps, RoundingMode.HALF_UP));
        }
        return sin;
    }
}
