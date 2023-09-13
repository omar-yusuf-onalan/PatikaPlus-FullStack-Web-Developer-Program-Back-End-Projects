package week01;
import java.util.Scanner;

// Sınıfı Geçme Durumu

public class SinifGecme {
    public static void main(String[] args) {
        int mat, fizik, turkce, kimya, muzik;
        int counter = 5;
        Scanner input = new Scanner(System.in);

        System.out.print("Matematik notunuzu giriniz: ");
        mat = input.nextInt();
        if ((mat <= 0) || (100 <= mat)) {
            mat = 0;
            counter--;
        }

        System.out.print("Fizik notunuzu giriniz: ");
        fizik = input.nextInt();
        if ((fizik <= 0) || (100 <= fizik)) {
            fizik = 0;
            counter--;
        }

        System.out.print("Türkçe notunuzu giriniz: ");
        turkce = input.nextInt();
        if ((turkce <= 0) || (100 <= turkce)) {
            turkce = 0;
            counter--;
        }

        System.out.print("Kimya notunuzu giriniz: ");
        kimya = input.nextInt();
        if ((kimya <= 0) || (100 <= kimya)) {
            kimya = 0;
            counter--;
        }

        System.out.print("Müzik notunuzu giriniz: ");
        muzik = input.nextInt();
        if ((muzik <= 0) || (100 <= muzik)) {
            muzik = 0;
            counter--;
        }

        int sum = mat + fizik + turkce + kimya + muzik;
        double result = (double) sum / counter;

        System.out.println("Not ortalamanız: " + result);

        String notKontrol = result >= 55.0 ? "Sınıfı Geçtiniz" : "Sınıfta Kaldınız";

        System.out.println(notKontrol);
    }
}
