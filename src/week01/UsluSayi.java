package week01;
import java.util.Scanner;

// Üslü Sayı Hesaplayan Program

public class UsluSayi {
    public static void main(String[] args) {
        int taban, kuvvet, usluSayi = 1;

        Scanner input = new Scanner(System.in);

        System.out.print("Sayınızın tabanını giriniz: ");
        taban = input.nextInt();

        System.out.print("Sayınızın kuvvetini giriniz: ");
        kuvvet = input.nextInt();

        for (int i = 0; i < kuvvet; i++) {
            usluSayi *= taban;
        }

        System.out.println(usluSayi);
    }
}
