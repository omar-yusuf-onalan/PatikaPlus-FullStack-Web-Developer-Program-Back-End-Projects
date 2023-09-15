package week01;
import java.util.Scanner;

// Ters Üçgen Yapımı

public class TersUcgen {
    public static void main(String[] args) {

        // Satır sayısını alacağımız değişkeni oluşturalım.
        int satir;

        Scanner input = new Scanner(System.in);

        // Kullanıcının girişini alalım.
        System.out.print("Sayı giriniz: ");
        satir = input.nextInt();

        // İç içe geçmiş for döngüleri ile ters üçgen yapalım.
        for (int i = satir; i >= 1; i--) {
            for (int j = 1; j <= satir - i; j++) {
                System.out.print(" ");
            }
            for (int x = 1; x <= (2 * i - 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
