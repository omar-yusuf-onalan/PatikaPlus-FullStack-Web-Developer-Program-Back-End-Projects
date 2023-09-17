package week02;
import java.util.Scanner;
import java.util.InputMismatchException;

// Recursive Metotlar ile Üslü Sayı Hesaplama

public class RecursivePow {

    static void recursivePow(Scanner input) {
        int num1, num2, result = 1;

        // We handle input errors through the try-catch method and InputMismatchException.
        while (true) {
            try {
                System.out.print("Enter first number: ");
                num1 = input.nextInt();

                System.out.print("Enter second number: ");
                num2 = input.nextInt();

                for (int i = 0; i < num2; i++) {
                    result *= num1;
                }

                System.out.println("Result: " + result);

                recursivePow(input);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                input.next();
            }
        }
    }
    /*
    It is a good idea to pass Scanner objects in `main` into methods for cleaner code. When there are many
    different methods taking inputs from a user, having to define the Scanner object each and every time you create a
    method goes against the clean code principle "DRY" (Don't Repeat Yourself).
    */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        recursivePow(input);
    }
}
