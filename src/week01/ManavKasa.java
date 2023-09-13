package week01;
import java.util.Scanner;

// Manav Kasa Programı

public class ManavKasa {
    public static void main(String[] args) {
        double armutKG = 2.14, elmaKG = 3.67, domatesKG = 1.11, muzKG = 0.95, patlicanKG = 5.00, toplam;
        double armutMiktar, elmaMiktar, domatesMiktar, muzMiktar, patlicanMiktar;

        Scanner input = new Scanner(System.in);

        System.out.print("Armut Kaç Kilo ? : ");
        armutMiktar = input.nextDouble();

        System.out.print("Elma Kaç Kilo ? : ");
        elmaMiktar = input.nextDouble();

        System.out.print("Domates Kaç Kilo ? : ");
        domatesMiktar = input.nextDouble();

        System.out.print("Muz Kaç Kilo ? : ");
        muzMiktar = input.nextDouble();

        System.out.print("Patlıcan Kaç Kilo ? : ");
        patlicanMiktar = input.nextDouble();

        toplam = (armutKG * armutMiktar) + (elmaKG * elmaMiktar) + (domatesKG * domatesMiktar) + (muzKG * muzMiktar) + (patlicanKG * patlicanMiktar);
        System.out.println("Toplam tutar: " + toplam);

    }
}
