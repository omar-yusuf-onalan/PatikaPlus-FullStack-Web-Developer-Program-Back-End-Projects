package week02;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

// Dizideki Maksimum ve Minimum Değerleri Bulan Program

public class ClosestNumberFinder {

    public static void closestNumberFinder (int[] array, Scanner input) {
        int lesserOne = 0, greaterOne = 0;
        Arrays.sort(array);

        System.out.print("Enter a number greater than " + array[0] + " but lesser than "+ array[array.length - 1] + ": ");
        int num = input.nextInt();

        if ((num <= array[0]) || (array[array.length - 1] <= num)) {
            throw new InputMismatchException("Please enter a valid number.");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (num == array[i]) {
                    lesserOne = array[i - 1];
                    greaterOne = array[i + 1];
                    break;
                } else if (num < array[i]) {
                    lesserOne = array[i - 1];
                    greaterOne = array[i];
                    break;
                }
            }
            System.out.println(
                "\nArray: " + Arrays.toString(array) +
                "\nEntered number: " + num +
                "\nNearest number lesser than the entered number: " + lesserOne +
                "\nNearest number greater than the entered number: " + greaterOne
            );
        }
    }
    public static void main(String[] args) {
        int[] list = {15, 12, 788, 1, -1, -778, 2, 0};

        Scanner input = new Scanner(System.in);

        closestNumberFinder(list, input);
    }
}
