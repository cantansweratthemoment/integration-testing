package functions.trigonometry;

import java.math.BigInteger;

public class Fac {
    static BigInteger calculateFactorial(int n) {
        BigInteger result = new BigInteger(String.valueOf(1));
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
