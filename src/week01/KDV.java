package week01;
import java.util.Scanner;

// KDV Tutarı Hesaplayan Program

public class KDV {
    public static void main(String[] args) {
        double fiyat, kdvOrani, kdvMiktari, kdvliFiyat;

        Scanner input = new Scanner(System.in);
        System.out.print("Ürün fiyatını giriniz: ");
        fiyat = input.nextDouble();

        kdvOrani = fiyat <= 1000 ? 0.18 : 0.08;

        kdvMiktari = fiyat * kdvOrani;
        kdvliFiyat = fiyat + kdvMiktari;

        System.out.println("Ürün fiyatı: " + fiyat);
        System.out.println("KDV oranı: " + kdvOrani);
        System.out.println("KDV tutarı: " + kdvMiktari);
        System.out.println("KDV'li ürün tutarı: " + kdvliFiyat);

    }
}
