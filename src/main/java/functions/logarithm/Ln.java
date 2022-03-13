package functions.logarithm;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Ln {

    public BigDecimal calculate(double x, double eps) {

        if(x <= 0){
            throw new ArithmeticException("x is less than or equals to 0");
        }

        BigDecimal constant = BigDecimal.valueOf(((x - 1) * (x - 1)) / ((x + 1) * (x + 1)));

        BigDecimal answer = new BigDecimal(0);
        BigDecimal currentValue = BigDecimal.valueOf((x - 1) / (x + 1));
        int step = 1;

        while (currentValue.abs().doubleValue() > eps / 2) {
            answer = answer.add(currentValue);
            BigDecimal multiply = new BigDecimal(2)
                    .multiply(BigDecimal.valueOf(step));

            currentValue = currentValue.multiply(
                    multiply
                            .subtract(BigDecimal.valueOf(1))
            ).multiply(constant)
                    .divide(
                            multiply
                                    .add(BigDecimal.valueOf(1))
                            , RoundingMode.HALF_UP);

            step++;
        }
        answer = answer.multiply(BigDecimal.valueOf(2));
        return answer;
    }
}
