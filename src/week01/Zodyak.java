package week01;
import java.util.Scanner;

// Çin Zodyağı Hesaplama

public class Zodyak {
    public static void main(String[] args) {
        int dogTarihi;
        String zodyak;

        Scanner input = new Scanner(System.in);

        System.out.print("Doğum Yılınızı Giriniz: ");
        dogTarihi = input.nextInt();

        if ((dogTarihi % 12) == 0) {
            zodyak = "Maymun";
        } else if ((dogTarihi % 12) == 1) {
            zodyak = "Horoz";
        } else if ((dogTarihi % 12) == 2) {
            zodyak = "Köpek";
        } else if ((dogTarihi % 12) == 3) {
            zodyak = "Domuz";
        } else if ((dogTarihi % 12) == 4) {
            zodyak = "Fare";
        } else if ((dogTarihi % 12) == 5) {
            zodyak = "Öküz";
        } else if ((dogTarihi % 12) == 6) {
            zodyak = "Kaplan";
        } else if ((dogTarihi % 12) == 7) {
            zodyak = "Tavşan";
        } else if ((dogTarihi % 12) == 8) {
            zodyak = "Ejderha";
        } else if ((dogTarihi % 12) == 9) {
            zodyak = "Yılan";
        } else if ((dogTarihi % 12) == 10) {
            zodyak = "At";
        } else {
            zodyak = "Koyun";
        }

        System.out.println("Çin Zodyağı Burcunuz: " + zodyak);
    }
}
