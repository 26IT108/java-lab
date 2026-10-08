import java.util.Scanner;
import java.util.InputMismatchException;

// Custom Exception
class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                double result;

                switch (op) {
                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':
                        if (num2 == 0) {
                            throw new DivideByZeroException("Cannot divide by zero.");
                        }
                        result = num1 / num2;
                        break;

                    default:
                        System.out.println("Invalid operator!");
                        continue;
                }

                System.out.println("Result = " + result);
                break;

            } catch (DivideByZeroException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Invalid number entered!");
                sc.nextLine(); // Clear invalid input

            } finally {
                System.out.println("Calculation attempt completed.\n");
            }
        }

        sc.close();
    }
}