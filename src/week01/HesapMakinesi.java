package week01;
import java.util.Scanner;

// Hesap Makinesi

public class HesapMakinesi {
    public static void main(String[] args) {
        int num1, num2, operator;

        Scanner input = new Scanner(System.in);

        System.out.println("1: Toplama\n2: Çıkarma\n3: Çarpma\n4: Bölme");

        System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
        operator = input.nextInt();

        System.out.print("Birinci sayıyı giriniz: ");
        num1 = input.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        num2 = input.nextInt();

        switch (operator) {
            case 1:
                System.out.println(num1 + num2);
                break;
            case 2:
                System.out.println(num1 - num2);
                break;
            case 3:
                System.out.println(num1 * num2);
                break;
            case 4:
                switch (num2) {
                    case 0:
                        System.out.println("Bir sayı 0'a bölünemez");
                        break;
                    default:
                        System.out.println(num1 / num2);
                        break;
                }
            default:
                System.out.println("Yanlış seçim yaptınız. Lütfen tekrar deneyiniz.");
        }

    }
}
