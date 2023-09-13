package week01;
import java.util.Scanner;

// Uçak Bileti Fiyatı Hesaplama

public class UcakBileti {
    public static void main(String[] args) {

        int mesafeKM, yas, yolculukTipi;
        double kmOrani = 0.10, yasIndirimOrani, tipIndirimOrani;
        double ilkFiyat, indirimliFiyat, sonTutar;

        Scanner input = new Scanner(System.in);

        System.out.print("Mesafeyi km türünden giriniz: ");
        mesafeKM = input.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        yas = input.nextInt();

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): ");
        yolculukTipi = input.nextInt();

        if ((mesafeKM > 0) && (yas > 0) && (0 < yolculukTipi) && (yolculukTipi < 3)) {
            ilkFiyat = mesafeKM * kmOrani;

            if (yas < 12) {
                yasIndirimOrani = 0.50;
            } else if (yas <= 24) {
                yasIndirimOrani = 0.10;
            } else if (yas > 65) {
                yasIndirimOrani = 0.30;
            } else {
                yasIndirimOrani = 0;
            }

            indirimliFiyat = ilkFiyat - (ilkFiyat * yasIndirimOrani);

            if (yolculukTipi == 2) {
                tipIndirimOrani = 0.20;
                sonTutar = 2 * (indirimliFiyat - (indirimliFiyat * tipIndirimOrani));
            } else {
                sonTutar = indirimliFiyat;
            }

            System.out.println("Toplam Tutar = " + sonTutar + " TL");
        } else {
            System.out.println("Hatalı veri girişi yaptınız. Lütfen tekrar deneyiniz.");
        }
    }
}
