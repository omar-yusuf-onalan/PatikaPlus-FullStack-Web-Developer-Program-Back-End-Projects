package week01;
import java.util.Scanner;

// Dairenin Alanını ve Çevresini Hesaplayan Program

public class Daire {
    public static void main(String[] args) {
        double pi = 3.14, r, alpha, alphaAlan;

        Scanner input = new Scanner(System.in);

        System.out.print("Dairenin yarıçapını giriniz: ");
        r = input.nextDouble();

        System.out.print("Dairenin diliminin açısını giriniz: ");
        alpha = input.nextDouble();

        alphaAlan = (pi * (Math.pow(r, 2)) * alpha) / 360;

        System.out.println("Daire diliminin alanı: " + alphaAlan);

/*
        double pi = 3.14, r, alan, cevre;

        System.out.print("Dairenin yarıçapını giriniz: ");

        Scanner input = new Scanner(System.in);
        r = input.nextDouble();

        alan = pi * Math.pow(r, 2);
        cevre = 2 * pi * r;

        System.out.println("Dairenin alanı: " + alan);
        System.out.println("Dairenin çevresi: " + cevre);
*/
    }
}
