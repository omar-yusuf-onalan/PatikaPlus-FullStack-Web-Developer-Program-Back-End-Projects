package week01;
import java.util.Scanner;

// Tip Dönüşümleri (Casting)

public class TipDonusumleri {
    public static void main(String[] args) {
        int sayi, ondalikliSayiInt;
        double ondalikliSayi, tamSayiDouble;

        Scanner input = new Scanner(System.in);

        // Kullanıcıdan tam sayı girmesini isteyelim.
        System.out.print("Tam sayı giriniz: ");
        sayi = input.nextInt();

        // Kullanıcıdan ondalıklı sayı girmesini isteyelim.
        System.out.print("Ondalıklı sayı giriniz: ");
        ondalikliSayi = input.nextDouble();

        // Tam sayıyı double tipine dönüştürelim.
        tamSayiDouble = (double) sayi;

        // Ondalıklı sayıyı int tipine dönüştürelim.
        ondalikliSayiInt = (int) ondalikliSayi;

        // Sonuçları ekrana yazdıralım.
        System.out.println("Tam sayının double hali: " + tamSayiDouble);
        System.out.println("Ondalıklı sayının int hali: " + ondalikliSayiInt);
    }
}
