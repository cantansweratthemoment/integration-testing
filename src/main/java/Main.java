import functions.function.Function;
import functions.trigonometry.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double eps = scanner.nextDouble();
        Function function = new Function();

        try {
            System.out.println(function.calculateTrig(x, eps));
        }catch (ArithmeticException exception){
            System.out.println(exception.getMessage());
        }
    }



}
