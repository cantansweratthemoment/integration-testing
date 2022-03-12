import functions.function.Function;
import functions.trigonometry.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int eps = scanner.nextInt();
        Function function = new Function(x, eps);

        try {
            BigDecimal bigDecimal = function.f1(x, eps);
            System.out.println(bigDecimal.floatValue());
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }



}
