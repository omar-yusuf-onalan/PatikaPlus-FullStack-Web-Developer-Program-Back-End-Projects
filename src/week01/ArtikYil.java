package week01;
import java.util.Scanner;

// Artık Yıl Hesaplama

public class ArtikYil {
    public static void main(String[] args) {
        int yil;

        Scanner input = new Scanner(System.in);

        System.out.print("Yıl giriniz: ");
        yil = input.nextInt();

        if (((yil % 4) == 0) && ((yil % 100 != 0))) {
            System.out.println(yil + ", bir artık yıldır!");
        } else if ((yil % 400) == 0) {
            System.out.println(yil + ", bir artık yıldır!");
        } else {
            System.out.println(yil + ", bir artık yıl değildir!");
        }
    }
}
