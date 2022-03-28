package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static util.math.Fac.calculateFactorial;


public class Sin {
    public BigDecimal calculateSin(double x, double eps) {
        BigDecimal answer = new BigDecimal("0");
        int n = 0;
        BigDecimal prev;
        do {
            prev = answer;
            answer = answer.add(new BigDecimal(-1).pow(n).multiply(new BigDecimal(x).pow(2 * n + 1)).divide(new BigDecimal(calculateFactorial(2 * n + 1)), 20, RoundingMode.HALF_UP));
            n++;
        } while (eps <= answer.subtract(prev).abs().doubleValue());

        return answer;
    }
}
