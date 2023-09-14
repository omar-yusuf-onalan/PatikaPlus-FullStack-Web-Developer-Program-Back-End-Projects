package week01;
import java.util.Scanner;

// Armstrong Sayıları Bulan Program

public class BasamakToplam {
    public static void main(String[] args) {
        int sayi, toplam = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Sayı giriniz: ");
        sayi = input.nextInt();

        String stringSayi = Integer.toString(sayi);

        for (int i = 0; i < stringSayi.length(); i++) {
            toplam += Character.getNumericValue(stringSayi.charAt(i));
        }
        System.out.println(toplam);
    }
}
