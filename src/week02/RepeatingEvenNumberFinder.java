package week02;

// Dizideki Tekrar Eden Sayıları Bulan Program

public class RepeatingEvenNumberFinder {

    public static boolean hasFound (int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {11, 14, 7, 18, 15,
                12, 3, 16, 10, 9,
                1, 10, 12, 11, 9,
                5, 9, 7, 10, 13,
                6, 18, 11, 20, 8,
                17, 6, 16, 18, 10,
                3, 17, 9, 6, 14,
                7, 11, 5, 16, 4,
                4, 19, 12, 2, 1,
                17, 1, 19, 10, 3};
        int[] temp = new int[numbers.length];
        int indexCounter = 0;
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if (((i != j) && (numbers[i] == numbers[j])) && (numbers[i] % 2 == 0)) {
                    if (!hasFound(temp, numbers[i])) {
                        temp[indexCounter] = numbers[i];
                        indexCounter++;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < indexCounter; i++) {
            System.out.println(temp[i]);
        }
    }
}
