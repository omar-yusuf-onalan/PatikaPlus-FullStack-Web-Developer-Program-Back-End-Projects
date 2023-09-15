package week01;
import java.util.Scanner;

// Mükemmel Sayı Bulan Program

public class MukemmelSayi {
    public static void main(String[] args) {
        int sayi, bolen = 1, toplam = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Sayı giriniz: ");
        sayi = input.nextInt();

        // 1'den girilen sayıya kadar olan sayıların girilen sayının böleni olup olmadığı kontrol edilir.
        while (sayi >= bolen) {

            // Girilen sayı, bolen değişkenine tam bölünüyorsa toplama eklenir.
            if (sayi % bolen == 0) {
                toplam += bolen;
            }

            bolen++;
        }

        // Mükemmel sayı olmanın şartı burada test edilir.
        if (toplam == 2 * sayi) {
            System.out.println(sayi + " Mükemmel sayıdır.");
        } else {
            System.out.println(sayi + " Mükemmel sayı değildir.");
        }
    }
}
