package functions.logarithm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Log {

    Ln ln = new Ln();

    public BigDecimal calculate(double x, double eps, double base) {
        BigDecimal answer = new BigDecimal(0);
        answer = answer.add(
                ln.calculate(x, eps)
                        .divide(ln.calculate(base, eps), RoundingMode.HALF_UP)
        );
        return answer;
    }
}
