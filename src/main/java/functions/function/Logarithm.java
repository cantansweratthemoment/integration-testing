package functions.function;

import functions.aClass.FunctionCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Logarithm extends FunctionCalculator {

    public Logarithm(double x, double eps) {
        super(x, eps);
    }

    public Logarithm() {
        super();
    }

    @Override
    public BigDecimal calculate() {
        BigDecimal answer = new BigDecimal(0);
        answer = answer.add(
                new BigDecimal(1)
                .multiply(log.calculate(x, eps, 5))
                .add(log.calculate(x, eps, 5))
                .subtract(
                        new BigDecimal(1)
                        .multiply(log.calculate(x, eps, 3))
                        .multiply(log.calculate(x, eps, 10))
                )
                .divide(log.calculate(x, eps, 2), RoundingMode.HALF_UP)
                .subtract(
                        new BigDecimal(1)
                        .multiply(log.calculate(x, eps, 2))
                        .add(
                                new BigDecimal(1)
                                .multiply(ln.calculate(x, eps))
                                .pow(2)
                        )
                )
                .subtract(log.calculate(x, eps, 3))
        );
        return answer;
    }
}
