package week02;
import java.util.Arrays;

// Dizideki Elemanların Ortalamasını Bulan Program

public class HarmonicArray {

    public static double calcHarmonicAvg (int[] array) {
        double sum = 0;
        for (int num : array) {
            sum += Math.pow( num, -1);
        }
        return array.length / sum;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(numbers) + "\nOutput: " + calcHarmonicAvg(numbers));
    }
}
