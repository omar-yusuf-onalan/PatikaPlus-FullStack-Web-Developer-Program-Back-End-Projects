package week02;
import java.util.Scanner;

// Palindrom Sayılar

public class PalindromeNum {
    static boolean isPalindrome (int num) {
        int lastDigit, reverseNum = 0, temp;

        temp = num;

        while (temp != 0) {
            lastDigit = temp % 10;
            reverseNum = (reverseNum * 10) + lastDigit;
            temp /= 10;
        }

        return num == reverseNum;
    }

    public static void main(String[] args) {
        int num;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to check if it is a palindrome number: ");
        num = input.nextInt();

        if (isPalindrome(num)) {
            System.out.print(num + " is a palindrome number.");
        } else {
            System.out.print(num + " is not a palindrome number.");
        }
    }
}
