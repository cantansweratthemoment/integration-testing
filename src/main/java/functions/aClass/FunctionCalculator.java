package functions.aClass;

import functions.function.Logarithm;
import functions.logarithm.Ln;
import functions.logarithm.Log;
import functions.trigonometry.*;

import java.math.BigDecimal;

public abstract class FunctionCalculator {

    public final Tan tan = new Tan();
    public final Sin sin = new Sin();
    public final Cos cos = new Cos();
    public final Cot cot = new Cot();
    public final Csc csc = new Csc();
    public final Sec sec = new Sec();
    public final Ln ln = new Ln();
    public final Log log = new Log();
    public double x;
    public double eps;

    public FunctionCalculator(double x, double eps){
        this.x = x;
        this.eps = eps;
    }

    public FunctionCalculator() {

    }


    public abstract BigDecimal calculate();
}
