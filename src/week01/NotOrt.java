package week01;
import java.util.Scanner;


// Not Ortalaması Hesaplayan Program

public class NotOrt {
    public static void main(String[] args) {
        int matematik, fizik, kimya, turkce, tarih, muzik;

        Scanner input = new Scanner(System.in);

        System.out.print("Matematik notunuzu giriniz: ");
        matematik = input.nextInt();

        System.out.print("Fizik notunuzu giriniz: ");
        fizik = input.nextInt();

        System.out.print("Kimya notunuzu giriniz: ");
        kimya = input.nextInt();

        System.out.print("Türkçe notunuzu giriniz: ");
        turkce = input.nextInt();

        System.out.print("Tarih notunuzu giriniz: ");
        tarih = input.nextInt();

        System.out.print("Müzik notunuzu giriniz: ");
        muzik = input.nextInt();

        int sum = matematik + fizik + kimya + turkce + tarih + muzik;
        double result = sum / 6.0;

        System.out.println("Not ortalamanız: " + result);

        String notKontrol = result >= 60.0 ? "Sınıfı Geçtiniz" : "Sınıfta Kaldınız";

        System.out.println(notKontrol);

    }
}
