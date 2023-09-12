package week01;
import java.util.Scanner;

// Taksimetre Hesaplayan Program

public class Taksimetre {
    public static void main(String[] args) {
        double mesafe, tutar = 10, kmUcreti = 2.20;

        Scanner input = new Scanner(System.in);

        System.out.print("Lütfen müşterinin gideceği yolu km cinsinden giriniz: ");

        mesafe = input.nextDouble();
        tutar += Math.floor(mesafe) * kmUcreti;

        tutar = tutar < 20 ? 20 : tutar;

        System.out.println("Tutar: " + tutar);

    }
}
