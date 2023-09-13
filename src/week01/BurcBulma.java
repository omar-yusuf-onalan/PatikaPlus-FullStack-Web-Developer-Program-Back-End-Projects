package week01;
import java.util.Scanner;

// Burç Bulan Program

public class BurcBulma {
    public static void main(String[] args) {
        int month, day;
        String burc = "";
        boolean error = false;

        Scanner input = new Scanner(System.in);

        System.out.print("Doğduğunuz ayı giriniz (1-12): ");
        month = input.nextInt();

        System.out.print("Doğduğunuz günü giriniz (1-31): ");
        day = input.nextInt();

        if (month == 1) {
            if (1 <= day && day <= 21) {
                burc = "Oğlak";
            } else if (22 <= day && day <= 31) {
                burc = "Kova";
            } else {
                error = true;
            }
        } else if (month == 2) {
            if (1 <= day && day <= 19) {
                burc = "Kova";
            } else if (20 <= day && day <= 28) {
                burc = "Balık";
            } else {
                error = true;
            }
        } else if (month == 3) {
            if (1 <= day && day <= 20) {
                burc = "Balık";
            } else if (21 <= day && day <= 31) {
                burc = "Koç";
            } else {
                error = true;
            }
        } else if (month == 4) {
            if (1 <= day && day <= 20) {
                burc = "Koç";
            } else if (21 <= day && day <= 30) {
                burc = "Boğa";
            } else {
                error = true;
            }
        } else if (month == 5) {
            if (1 <= day && day <= 21) {
                burc = "Boğa";
            } else if (22 <= day && day <= 31) {
                burc = "İkizler";
            } else {
                error = true;
            }
        } else if (month == 6) {
            if (1 <= day && day <= 22) {
                burc = "İkizler";
            } else if (23 <= day && day <= 30) {
                burc = "Yengeç";
            } else {
                error = true;
            }
        } else if (month == 7) {
            if (1 <= day && day <= 22) {
                burc = "Yengeç";
            } else if (23 <= day && day <= 31) {
                burc = "Aslan";
            } else {
                error = true;
            }
        } else if (month == 8) {
            if (1 <= day && day <= 22) {
                burc = "Aslan";
            } else if (23 <= day && day <= 31) {
                burc = "Başak";
            } else {
                error = true;
            }
        } else if (month == 9) {
            if (1 <= day && day <= 22) {
                burc = "Başak";
            } else if (23 <= day && day <= 30) {
                burc = "Terazi";
            } else {
                error = true;
            }
        } else if (month == 10) {
            if (1 <= day && day <= 22) {
                burc = "Terazi";
            } else if (23 <= day && day <= 31) {
                burc = "Akrep";
            } else {
                error = true;
            }
        } else if (month == 11) {
            if (1 <= day && day <= 21) {
                burc = "Akrep";
            } else if (22 <= day && day <= 30) {
                burc = "Yay";
            } else {
                error = true;
            }
        } else if (month == 12) {
            if (1 <= day && day <= 21) {
                burc = "Yay";
            } else if (22 <= day && day <= 31) {
                burc = "Oğlak";
            } else {
                error = true;
            }
        } else {
            error = true;
        }
        if (error) {
            System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyiniz");
        } else {
            System.out.println("Burcunuz " + burc);
        }
    }
}
