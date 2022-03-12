package functions.function;

import functions.trigonometry.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Function {
    double x;
    int eps;
    Tan tan = new Tan();
    Sin sin = new Sin();
    Cos cos = new Cos();
    Cot cot = new Cot();
    Csc csc = new Csc();
    Sec sec = new Sec();

    public Function(double x, int eps){
        this.x = x;
        this.eps = eps;
    }

    public BigDecimal f1(double x, int eps) {
        BigDecimal bigDecimal = new BigDecimal(0);
        bigDecimal = bigDecimal
                .add(tan.calculate(x, eps).getNumber())
                .add(cot.calculate(x, eps).getNumber())
                .subtract(csc.calculate(x, eps).getNumber())
                .divide(tan.calculate(x, eps).getNumber(), RoundingMode.HALF_UP)
                .subtract(sin.calculateSin(x, eps))
                .pow(2)
                .add(sin.calculateSin(x, eps))
                .divide(tan.calculate(x, eps).getNumber(), RoundingMode.HALF_UP);
        return bigDecimal;
    }
}
