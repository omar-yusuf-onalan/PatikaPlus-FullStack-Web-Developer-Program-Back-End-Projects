package week01;
import java.util.Scanner;

// Faktöriyel Hesaplayan Program

public class Kombinasyon {
    public static void main(String[] args) {
        int n, r;
        int nf = 1, rf = 1, nrf =1;
        int C;

        Scanner input = new Scanner(System.in);

        System.out.print("Birinci sayıyı giriniz: ");
        n = input.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        r = input.nextInt();

        // n!
        for (int i = n; i > 0; i--) {
            nf *= i;
        }

        // r!
        for (int i = r; i > 0; i--) {
            rf *= i;
        }

        // (n-r)!
        for (int i = (n - r); i > 0; i--) {
            nrf *= i;
        }

        C = nf / (rf * nrf);

        System.out.println("Giriğiniz sayıların kombinasyonu: " + C);
    }
}
