package week02;
import java.util.Scanner;

// Recursive ile Fibonacci Serisi Bulan Program

public class RecursiveFib {

    static int fib (int num) {
        if (num == 1) {
            return 0;
        } else if (num == 2) {
            return 1;
        } else {
            return fib (num - 1) + fib (num - 2);
        }
    }

    public static void main(String[] args) {
        int num;

        Scanner input = new Scanner(System.in);

        System.out.print("Which element of the Fibonacci Sequence would you like to view? Enter a number: ");
        num = input.nextInt();

        System.out.println(fib(num));
    }
}
