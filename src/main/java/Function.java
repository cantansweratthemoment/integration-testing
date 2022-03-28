import functions.function.Logarithm;
import functions.function.Trigonometry;

import java.math.BigDecimal;

public class Function {
    private Logarithm logarithm;
    private Trigonometry trigonometry;

    public Function(Logarithm logarithm, Trigonometry trigonometry) {
        this.logarithm = logarithm;
        this.trigonometry = trigonometry;
    }

    public BigDecimal calculate(Double x) {
        if (x > 0) {
            logarithm.x = x;
            return logarithm.calculate();
        } else {
            trigonometry.x = x;
            return trigonometry.calculate();
        }
    }
}
