package week01;
import java.util.Scanner;

// Harmonik Sayıları Bulan Program

public class HarmonikSayi {
    public static void main(String[] args) {
        int sayi;
        double toplam = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Sayı giriniz: ");
        sayi = input.nextInt();

        for (int i = 1; i <= sayi; i++) {
            toplam += Math.pow(i, -1);
        }
        System.out.println("Harmonik sayı: " + toplam);
    }
}
