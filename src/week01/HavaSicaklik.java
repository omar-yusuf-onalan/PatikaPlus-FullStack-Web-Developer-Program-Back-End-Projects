package week01;
import java.util.Scanner;

// Hava Sıcaklığına Göre Etkinlik Önerme

public class HavaSicaklik {
    public static void main(String[] args) {
        double sicaklik;

        Scanner input = new Scanner(System.in);

        System.out.print("Bugünün sıcaklığını giriniz: ");
        sicaklik = input.nextDouble();

        if(sicaklik < 5) {
            System.out.println("Bugün kayak yapmaya gidebilirsiniz.");
        } else if (5 <= sicaklik && sicaklik < 15) {
            System.out.println("Bugün sinemaya gidebilirsiniz.");
        } else if (15 <= sicaklik && sicaklik <= 25) {
            System.out.println("Bugün piknik yapmaya gidebilirsiniz.");
        } else {
            System.out.println("Bugün yüzmeye gidebilirsiniz.");
        }
    }
}
