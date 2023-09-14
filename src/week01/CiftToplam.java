package week01;
import java.util.Scanner;

// Tek Sayıların Toplamını Program

public class CiftToplam {
    public static void main(String[] args) {
        int sayi, toplam = 0;

        Scanner input = new Scanner(System.in);


        do {
            System.out.print("Sayılar giriniz: ");

            sayi = input.nextInt();

            if ((sayi % 4) == 0) {
                toplam += sayi;
            }

        } while ((sayi % 2) == 0);

        System.out.println("Tek bir sayı girdiniz. Program durduruldu. Şu ana kadar giriş yaptığınız sayılardan 4'ün katı olanların toplamı: " + toplam);

    }
}
