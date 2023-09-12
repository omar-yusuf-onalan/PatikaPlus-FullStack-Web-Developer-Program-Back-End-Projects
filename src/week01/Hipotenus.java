package week01;
import java.util.Scanner;

// Dik Üçgende Hipotenüs Bulan Program

public class Hipotenus {
    public static void main(String[] args) {
        int kenar1, kenar2, kenar3;
        double u, alan;

        Scanner input = new Scanner(System.in);

        System.out.print("Birinci kenarın uzunluğunu giriniz: ");
        kenar1 = input.nextInt();
        System.out.print("İkinci kenarın uzunluğunu giriniz: ");
        kenar2 = input.nextInt();
        System.out.print("Üçüncü kenarın uzunluğunu giriniz: ");
        kenar3 = input.nextInt();

        u = (double) (kenar1 + kenar2 + kenar3) / 2;
        alan = Math.sqrt(u * (u - kenar1) * (u - kenar2) * (u - kenar3));

        System.out.println("Üçgenin çevresi: " + u * 2);
        System.out.println("Üçgenin alanı: " + alan);


/*
        int kenar1, kenar2;
        double hipotenus;

        Scanner input = new Scanner(System.in);

        System.out.print("Birinci kenarın uzunluğunu giriniz: ");
        kenar1 = input.nextInt();
        System.out.print("İkinci kenarın uzunluğunu giriniz: ");
        kenar2 = input.nextInt();

        hipotenus = Math.sqrt(Math.pow(kenar1, 2) + Math.pow(kenar2, 2));

        System.out.println("Hipotenüs: " + hipotenus);
*/

    }

}
