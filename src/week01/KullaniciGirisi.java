package week01;
import java.util.Scanner;

// Kullanıcı Girişi

public class KullaniciGirisi {
    public static void main(String[] args) {
        String userName, pw;

        Scanner input = new Scanner(System.in);

        System.out.print("Kullanıcı adınızı giriniz: ");
        userName = input.nextLine();

        System.out.print("Şifrenizi giriniz: ");
        pw = input.nextLine();

        if (userName.equals("patika") && pw.equals("java123")) {
            System.out.println("Giriş yaptınız.");
        } else {
            System.out.println("Kullanıcı adı ile şifre uyuşmadı.");
            String newPw;

            System.out.println("Şifrenizi sıfırlamak ister misiniz? (Y/N)");
            String cevap = input.nextLine();

            if (cevap.equals("y") || cevap.equals("Y")) {

                System.out.print("Oluşturmak istediğiniz şifreyi giriniz: ");
                newPw = input.nextLine();

                if (newPw.equals("java123")) {
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                } else {
                    pw = newPw;
                    System.out.println("Şifre oluşturuldu.");
                }
            } else if (cevap.equals("n") || cevap.equals("N")){
                    System.out.println("Şifre sıfırlama işlemi durduruldu.");
            } else {
                    System.out.println("Yanlış işlem yaptınız. Lüften tekrar deneyiniz.");
            }

        }

    }
}
