import functions.aClass.FunctionCalculator;
import functions.function.Trigonometry;
import functions.function.Logarithm;
import functions.logarithm.Ln;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double eps = scanner.nextDouble();
        //FunctionCalculator trigonometry = new Trigonometry(x, eps);
        //FunctionCalculator logarithm = new Logarithm(x, eps);

        //System.out.println(logarithm.calculate());
        //System.out.println(trigonometry.calculate());

        Ln ln = new Ln();
        System.out.println(ln.calculate(0.1, 0.0001));
    }
}
