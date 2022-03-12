package functions.trigonometry;

import functions.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.PI;

public class Csc {
    Sin sin = new Sin();

    public Number calculate(double x, int eps) {
        if ((x % PI == 0) ) {
            return new Number(null, true);
        }
        return new Number(new BigDecimal(1).divide(sin.calculateSin(x, eps), eps, RoundingMode.HALF_UP), false);
    }
}
