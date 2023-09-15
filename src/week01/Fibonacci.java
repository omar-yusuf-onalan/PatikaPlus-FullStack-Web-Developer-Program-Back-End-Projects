package week01;
import java.util.Scanner;

// Fibonacci Serisi

public class Fibonacci {
    public static void main(String[] args) {
        // Fibonacc serisinin 3 elemanını da kayıt altında tutuyoruz.
        int eleman, sayi = 0, oncekiToplam = 1;
        int yeniToplam = sayi + oncekiToplam;

        Scanner input = new Scanner(System.in);

        // Kullanıcıdan girdi alalım.
        System.out.print("Sayı giriniz: ");
        eleman = input.nextInt();

        /*
                   (1)
            0 + 1 = 1
            1 + 1 = 2
            1 + 2 = 3
            2 + 3 = 5
            3 + 5 = 8
            ...
        For döngüsünün içindeki değişken atamalarına bakarken yukarıdaki işlemlere dikkat edin
        Değişkenler açısından incelersek sayi her zaman oncekiToplam oluyor, oncekiToplam yeniToplam oluyor,
        yeniToplam değerleri güncellenmiş sayi ve oncekiToplam değişkenlerinin toplamı oluyor.
         */
        for (int i = 0; i < eleman; i++) {
            System.out.println(sayi + "+" + oncekiToplam + "=" + yeniToplam);
            sayi = oncekiToplam;
            oncekiToplam = yeniToplam;
            yeniToplam = sayi + oncekiToplam;
        }
    }
}
