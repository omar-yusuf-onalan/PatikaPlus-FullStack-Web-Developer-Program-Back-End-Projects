package week02;
import java.util.Scanner;

// Desene Göre Metot Oluşturma

public class RecursivePattern {
    /*
    This problem has two phases, decreasing and increasing, and we need to use boolean flags in order to manage
    the direction of the recursive method. Without a boolean flag, the increasing phase is always interrupted by
    the decreasing phase's if statement (the first if statement). As soon as temp becomes a positive number, it
    fulfills the first condition of the first if statement (temp > 0), starts another decreasing phase that
    lasts for one iteration, and creates an infinite loop with the same two numbers.
    */
    public static void recursivePattern(int temp, int num, boolean isDecreasing) {
        System.out.print(temp + " ");

        if (temp > 0 && isDecreasing) {
            recursivePattern(temp - 5, num, true);
        } else if (temp < num) {
            recursivePattern(temp + 5, num, false);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int num = input.nextInt();

        recursivePattern(num, num, true);

        input.close();
    }
}
