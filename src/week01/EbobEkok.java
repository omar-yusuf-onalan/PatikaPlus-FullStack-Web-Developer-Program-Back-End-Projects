package week01;
import java.util.Scanner;

// EBOB-EKOK Bulan Program

public class EbobEkok {
    public static void main(String[] args) {
        int num1, num2;
        int ebob =1, ekok = 1;
        int tempEbob = 1;
        Scanner input = new Scanner(System.in);

        System.out.print("Birinci sayıyı giriniz: ");
        num1 = input.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        num2 = input.nextInt();

        if (num1 == num2) {
            System.out.println("Girdiğiniz sayıların EBOB'u " + num1 + " ve EKOK'u " + num2);
        } else if (num1 > num2) {
            while (num2 >= tempEbob) {
                if ((num1 % tempEbob == 0) && (num2 % tempEbob == 0)) {
                    ebob = tempEbob;
                }
                tempEbob++;
            }
            ekok = (num1 * num2) / ebob;
            System.out.println("Girdiğiniz sayıların EBOB'u " + ebob + " ve EKOK'u " + ekok);
        } else {
            while (num1 >= tempEbob) {
                if ((num1 % tempEbob == 0) && (num2 % tempEbob == 0)) {
                    ebob = tempEbob;
                }
                tempEbob++;
            }
            ekok = (num1 * num2) / ebob;
            System.out.println("Girdiğiniz sayıların EBOB'u " + ebob + " ve EKOK'u " + ekok);
        }
    }
}
