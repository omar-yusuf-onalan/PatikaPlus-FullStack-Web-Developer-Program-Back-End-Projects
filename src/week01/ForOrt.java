package week01;
import java.util.Scanner;

// Girilen Sayıya Kadar Olan Çift Sayıları Bulan Program

public class ForOrt {
    public static void main(String[] args) {
        int num, sum = 0, counter = 0;
        double ort;

        System.out.println("0'dan girilen sayıya kadar olan sayılardan 3 ve 4'e tam bölünen sayıların ortalamasını hesaplayan program");
        System.out.print("Sayı giriniz: ");
        Scanner input = new Scanner(System.in);

        num = input.nextInt();

        if (num >= 0) {
            for (int i = 0; i <= num; i++) {
                if ((i % 3 == 0) && (i % 4 == 0)) {
                    sum += i;
                    counter++;
                    System.out.println(i);
                }
            }

            ort = (double) sum / counter;
            System.out.println("Ortalama: " + ort);

        } else {
            System.out.println("Negatif bir sayı girdiniz.");
        }

    }
}
