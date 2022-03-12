package functions;

import java.math.BigDecimal;

public class Number {
    BigDecimal number;
    boolean isNan;

    public Number(BigDecimal number, boolean isNan) {
        this.number = number;
        this.isNan = isNan;
    }

    public Number() {

    }

    public BigDecimal getNumber() {
        return number;
    }

    public boolean isNan(){
        return isNan;
    }
}
