package functions.trigonometry;

import functions.Number;

import java.math.RoundingMode;

import static java.lang.Math.PI;

public class Tan {
    Sin sin = new Sin();
    Cos cos = new Cos();

    public Number calculate(double x, int eps) {
        if ((x % (PI / 2) == 0 || x % ((3 * PI) / 2) == 0) && x % PI != 0) {
            return new Number(null, true);
        }
        return new Number(sin.calculateSin(x, eps).divide(cos.calculateCos(x, eps), eps, RoundingMode.HALF_UP), false);
    }

}
