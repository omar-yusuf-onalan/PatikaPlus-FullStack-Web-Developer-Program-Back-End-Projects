package week01;
import java.util.Scanner;

// Girilen Sayıdan Küçük 2’nin Kuvvetlerini Bulan Program

public class KuvvetDortBes {
    public static void main(String[] args) {
        int sayi;

        Scanner input = new Scanner(System.in);

        System.out.print("Sayı giriniz: ");
        sayi = input.nextInt();

        for (int i = 1; i <= sayi; i*=4) {
            System.out.println("4'ün kuvvetleri: " + i);
        }
        for (int i = 1; i <= sayi; i*=5) {
            System.out.println("5'in kuvvetleri: " + i);
        }
    }
}
