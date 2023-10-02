package week05.TryCatchBlock;

import java.util.Scanner;

public class TryCatchBlock {
    public static void getElementByIndex(int[] array, int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || array.length - 1 < index) {
            throw new ArrayIndexOutOfBoundsException("Invalid index inputted");
        }

        System.out.println("The element at index " + index + " is " + array[index]);
    }

    public static void main(String[] args) {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index: ");
        int index = input.nextInt();

        try{
            getElementByIndex(intArray, index);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        input.close();
    }
}
