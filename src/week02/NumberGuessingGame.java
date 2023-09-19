package week02;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

// Sayı Tahmin Oyunu

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int guess = random.nextInt(101);

        Scanner input = new Scanner(System.in);
        int attempts = 0;
        int selected;
        int[] wrongGuesses = new int[5];
        boolean hasWon = false;

        while (attempts < 5) {
            System.out.print("Please enter your guess (0-100): ");
            selected = input.nextInt();

            if (selected < 0 || 100 < selected) {
                System.out.println("Please enter a value between 0-100.");

                wrongGuesses[attempts] = selected;

                attempts++;

                continue;
            }

            if (selected == guess) {
                System.out.println("Congratulations, correct guess! The number you guessed is: " + guess);
                hasWon = true;
                break;
            } else {
                System.out.println("You entered an incorrect number!");
                if (selected > guess) {
                    System.out.println(selected + " is greater than the hidden number.");
                } else {
                    System.out.println(selected + " is smaller than the hidden number.");
                }

                wrongGuesses[attempts++] = selected;
                System.out.println("Remaining attempts: " + (5 - attempts));
            }
        }

        if (!hasWon) {
            System.out.println("You lost!");
            System.out.println("Your guesses were: " + Arrays.toString(wrongGuesses));
        }
        input.close();
    }
}
