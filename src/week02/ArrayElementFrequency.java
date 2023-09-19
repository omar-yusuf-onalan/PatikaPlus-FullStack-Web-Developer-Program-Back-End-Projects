package week02;
import java.util.Arrays;

// Dizideki Elemanların Frekansı

public class ArrayElementFrequency {

    public static void frequencyChecker(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));

        Arrays.sort(array);

        int i = 0;

        while (i < array.length) {
            int counter = 1;

            while (i < array.length - 1 && array[i] == array[i + 1]) {
                counter++;
                i++;
            }

            System.out.println("Frequency of " + array[i] + ": " + counter);

            i++;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 20, 10, 10, 20, 5, 20};

        frequencyChecker(numbers);
    }
}

