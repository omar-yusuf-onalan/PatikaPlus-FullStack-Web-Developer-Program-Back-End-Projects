package week02;
import java.util.Scanner;
import java.util.InputMismatchException;

// Asal Sayı Bulan Program

public class RecursivePrime {
    static void recursivePrime(Scanner input) {
        // We handle input errors through the try-catch construct and InputMismatchException.
        while (true) {
            try {
                int num, bolen = 2;

                System.out.print("Enter a number: ");
                num = input.nextInt();

                while ((num >= bolen) && (num % bolen != 0)) {
                    bolen++;
                }
                if (num == bolen) {
                    System.out.println(num + " is a prime number");
                } else {
                    System.out.println(num + " is not a prime number");
                }

                recursivePrime(input);
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

        recursivePrime(input);
    }
}
