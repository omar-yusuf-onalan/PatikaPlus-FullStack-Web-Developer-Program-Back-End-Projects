package week01;
import java.util.Scanner;

// Vücut Kitle İndeksi Hesaplama

public class VucutKitle {
    public static void main(String[] args) {
        double kilo, boy, vki;

        Scanner input = new Scanner(System.in);

        System.out.print("Lüften boyunuzu (metre cinsinde) giriniz: ");
        boy = input.nextDouble();

        System.out.print("Lüften kilonuzu giriniz: ");
        kilo = input.nextDouble();

        vki = kilo / Math.pow(boy, 2);

        System.out.println("Vücut Kitle İndeksiniz: " + vki);

    }
}
