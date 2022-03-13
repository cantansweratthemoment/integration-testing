import functions.aClass.FunctionCalculator;
import functions.function.Trigonometry;
import functions.function.Logarithm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double eps = scanner.nextDouble();
        FunctionCalculator trigonometry = new Trigonometry(x, eps);
        FunctionCalculator logarithm = new Logarithm(x, eps);

        //todo: норм ввод и тд
        try {
            System.out.println(trigonometry.calculate());
        }catch (ArithmeticException exception){
            System.out.println(exception.getMessage());
        }
    }



}
