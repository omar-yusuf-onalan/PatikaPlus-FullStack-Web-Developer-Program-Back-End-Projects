package week01;
import java.util.Scanner;
import java.util.Arrays;

// Girilen Sayılardan Min ve Max Değerleri Bulma

public class MinMax {
    public static void main(String[] args) {
        int n;

        Scanner input = new Scanner(System.in);

        System.out.print("Kaç tane sayı gireceksiniz: ");
        n = input.nextInt();

        // Burada n pozitif bir sayı olmalı çünkü negatif bir sayı veya 0 girmek programın mantığına aykırıdır.
        if (n > 0) {
            // İçinde int türünde değerler tutacak olan "sayilar" adında bir array oluşturdum.
            int[] sayilar = new int[n];

            // Bu for loop sayesinde girilen sayıları "sayilar" array'ine sırasıyla index'ine göre diziliyor.
            for (int i = 1; i <= n; i++) {
                System.out.print(i + ". sayıyı giriniz: ");

                // [i - 1] çünkü i 1 değeri ile başlıyor ama Java'da index'leme 0 ile başlıyor.
                sayilar[i - 1] = input.nextInt();
            }
            /*
            Yukarıda importlama komutlarında gördüğünüz gibi Arrays sınıfının metotlarından birinden faydalandım.
            Bu metot (Arrays.sort()) bir array'in içindeki değerleri küçükten büyüğe doğru (ascending order) sıralar.
            */
            Arrays.sort(sayilar);

            /*
            n tane sayı girilmişse ve en son index'teki sayı en büyüğü olacak ise o zaman [n - 1]. index'teki sayıyı
            baz alırsam girilen sayılar arasındaki en büyüğü elde etmiş olurum. En küçük sayı doğal olarak 0.
            index'te olur.
            */
            System.out.println("En büyük sayı: " + sayilar[n - 1]);
            System.out.println("En küçük sayı: " + sayilar[0]);
        } else {
            System.out.println("Hatalı veri giriş yaptınız.");
        }
    }
}
