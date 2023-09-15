package week01;
import java.util.Scanner;

// Aritmetik İşlemler ve İşlem Önceliği

public class Aritmetik {
    public static void main(String[] args) {
        // Değişkenleri oluşturalım.
        int a, b, c;

        // Kullanacağımız Scanner'ı tanımlayalım.
        Scanner input = new Scanner(System.in);

        // Kullanıcımızdan 3 tane sayıyı girdi olarak alalım.
        System.out.print("Birinci sayıyı giriniz: ");
        a = input.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        b = input.nextInt();

        System.out.print("Üçüncü sayıyı giriniz: ");
        c = input.nextInt();

        // Sorunun bizden istediği işlemi yapalım.
        System.out.println(a + (b * c) - b);
    }
}
