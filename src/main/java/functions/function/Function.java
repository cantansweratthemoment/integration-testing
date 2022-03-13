package functions.function;

import functions.trigonometry.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Function {
    private final Tan tan = new Tan();
    private final Sin sin = new Sin();
    private final Cos cos = new Cos();
    private final Cot cot = new Cot();
    private final Csc csc = new Csc();
    private final Sec sec = new Sec();


    public BigDecimal calculateTrig(double x, double eps) throws ArithmeticException{
        BigDecimal answer = new BigDecimal(0);
        answer = answer.add(
                new BigDecimal(0)
                        .add(tan.calculate(x, eps))
                        .add(cot.calculate(x, eps))
                        .divide(sec.calculate(x, eps), RoundingMode.HALF_UP)
                        .subtract(csc.calculate(x, eps))
                        .divide(tan.calculate(x, eps), RoundingMode.HALF_UP)
                        .subtract(sin.calculateSin(x, eps))
                        .pow(2)
                        .add(sin.calculateSin(x, eps))
                        .divide(tan.calculate(x, eps), RoundingMode.HALF_UP)
                        .subtract(cos.calculateCos(x, eps))
                        .subtract(tan.calculate(x, eps))
                        .subtract(
                                new BigDecimal(0)
                                        .add(sec.calculate(x, eps))
                                        .add(cos.calculateCos(x, eps))
                                        .subtract(
                                                new BigDecimal(0)
                                                        .add(csc.calculate(x, eps))
                                                        .pow(3)
                                        )
                        ).add(
                        new BigDecimal(0)
                                .add(cot.calculate(x, eps))
                                .subtract(cot.calculate(x, eps))
                ).pow(2)
        ).multiply(
                new BigDecimal(0)
                        .add(sec.calculate(x, eps))
                        .divide(
                                new BigDecimal(0)
                                        .add(cos.calculateCos(x, eps))
                                        .divide(csc.calculate(x, eps), RoundingMode.HALF_UP)
                                , RoundingMode.HALF_UP
                        )
                        .multiply(csc.calculate(x, eps))
                        .add(
                                new BigDecimal(0)
                                        .add(sin.calculateSin(x, eps))
                                        .multiply(sec.calculate(x, eps))
                        )
                        .subtract(
                                new BigDecimal(0)
                                        .add(csc.calculate(x, eps))
                                        .pow(2)
                        )
                        .add(
                                new BigDecimal(0)
                                        .add(sec.calculate(x, eps))
                                        .divide(tan.calculate(x, eps), RoundingMode.HALF_UP)
                                        .subtract(tan.calculate(x, eps))
                                        .divide(
                                                new BigDecimal(0)
                                                        .add(cot.calculate(x, eps))
                                                        .subtract(
                                                                new BigDecimal(0)
                                                                        .add(tan.calculate(x, eps))
                                                                        .add(sin.calculateSin(x, eps))
                                                        )
                                                        .divide(cos.calculateCos(x, eps), RoundingMode.HALF_UP)
                                                , RoundingMode.HALF_UP
                                        )
                        )
                        .subtract(sec.calculate(x, eps))
                        .pow(3)
        )
                .pow(2)
                .pow(2)
                .pow(3);
        return answer;
    }
}
