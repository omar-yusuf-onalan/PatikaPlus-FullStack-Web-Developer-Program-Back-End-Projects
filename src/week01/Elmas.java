package week01;
import java.util.Scanner;

// Yıldızlar ile Üçgen Yapımı

public class Elmas {
    public static void main(String[] args) {
        int satir;

        Scanner input = new Scanner(System.in);

        System.out.print("Sayı giriniz: ");
        satir = input.nextInt();

        // Üst katman
        for (int i = 1; i <= satir; i++) {
            for (int j = 1; j <= satir - i; j++) {
                System.out.print(" ");
            }
            for (int x = 1; x <= (2 * i - 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Alt katman
        for (int i = satir - 1; i >= 1; i--) {
            for (int j = 1; j <= satir - i; j++) {
                System.out.print(" ");
            }
            for (int x = 1; x <= (2 * i - 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
