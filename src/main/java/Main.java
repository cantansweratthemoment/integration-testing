import functions.aClass.FunctionCalculator;
import functions.function.Trigonometry;
import functions.function.Logarithm;
import functions.logarithm.Ln;
import functions.trigonometry.Cos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double eps = scanner.nextDouble();
        Trigonometry trigonometry = new Trigonometry(x, eps);
        Logarithm logarithm = new Logarithm(x, eps);



       Function function = new Function(logarithm, trigonometry);
        System.out.println(function.calculate(x));
    }
}
