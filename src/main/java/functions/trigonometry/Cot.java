package functions.trigonometry;

import functions.Number;

import java.math.RoundingMode;

import static java.lang.Math.*;

public class Cot {
    Sin sin = new Sin();
    Cos cos = new Cos();

    public Number calculate(double x, int eps) {
        if (x % PI == 0) {
            return new Number(null, true);
        }
        return new Number(cos.calculateCos(x, eps).divide(sin.calculateSin(x, eps), eps, RoundingMode.HALF_UP), false);
    }
}
