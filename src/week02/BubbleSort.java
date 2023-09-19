package week02;
import java.util.Arrays;
import java.util.Scanner;

// Dizideki Elemanları Sıralama

public class BubbleSort { // Bubble Sort is a basic sorting algorithm.
    private static void bubbleSort(int[] array) {
        // We use "wasSwapped" in case the array is already sorted.
        boolean wasSwapped = false;

        // i keeps track of the amount of numbers that have been sorted to the left of the array.
        for (int i = 0; i < array.length - 1; i++) {
            // j is the variable that we use to swap the elements of the array if they meet a certain condition.
            for (int j = 0; j < array.length - 1 - i; j++) {
                // Among two elements that are adjacent, if the one on the left is greater than the one on the right,
                // it means that we must swap their positions. We keep doing this until the array is sorted.
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;

                    // If there has been any sorting in the array, we set this variable to true.
                    wasSwapped = true;
                }
            }
            // If no element in the array was swapped, this means that the array was already sorted. The loop can be directly terminated.
            if (!wasSwapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("The number of elements in the array: ");
        int arrayLength = input.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter your " + (i + 1) + ". number: ");
            int number = input.nextInt();
            array[i] = number;
        }

        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }
}
