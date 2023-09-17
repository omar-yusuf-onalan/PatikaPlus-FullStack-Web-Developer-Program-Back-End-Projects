package week02;
import java.util.Scanner;
import java.util.InputMismatchException;

// Gelişmiş Hesap Makinesi

public class AdvancedCalculator {
    static void plus(Scanner input) {
        int number, result = 0, i = 1;
        while (true) {
            System.out.print("Enter " + i++ + ". number: ");
            number = input.nextInt();
            if (number == 0) {
                break;
            }
            result += number;
        }
        System.out.println("Result: " + result);
    }

    static void minus(Scanner input) {
        System.out.print("How many numbers will you enter: ");
        int counter = input.nextInt();
        int number, result = 0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". number: ");
            number = input.nextInt();
            if (i == 1) {
                result += number;
                continue;
            }
            result -= number;
        }

        System.out.println("Result: " + result);
    }

    static void times(Scanner input) {
        int number, result = 1, i = 1;

        while (true) {
            System.out.print(i++ + ". number: ");
            number = input.nextInt();

            if (number == 1)
                break;

            if (number == 0) {
                result = 0;
                break;
            }
            result *= number;
        }

        System.out.println("Result: " + result);
    }

    static void divided(Scanner input) {
        System.out.print("How many numbers will you enter: ");
        int counter = input.nextInt();
        double number, result = 0.0;

        for (int i = 1; i <= counter; i++) {
            while (true) {
                try {
                    System.out.print(i + ". number: ");
                    number = input.nextDouble();
                    if (i != 1 && number == 0) {
                        System.out.println("You cannot enter 0 as a divisor. Please try again.");
                        continue;
                    }
                    if (i == 1) {
                        result = number;
                    } else {
                        result /= number;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    input.next();
                }
            }
        }

        System.out.println("Result: " + result);
    }


    static void power(Scanner input) {
        System.out.print("Enter the base value: ");
        int base = input.nextInt();
        System.out.print("Enter the exponent value: ");
        int exponent = input.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println("Result: " + result);
    }

    static void factorial(Scanner input) {
        System.out.print("Enter a number: ");
        int num1 = input.nextInt();
        int result = 1;

        for (int i = 1; i <= num1; i++) {
            result *= i;
        }

        System.out.println("Result: " + result);
    }

    static void mod(Scanner input) {
        System.out.print("Enter a number: ");
        int num1 = input.nextInt();

        System.out.print("Enter another number: ");
        int num2 = input.nextInt();

        int result = num1 % num2;

        System.out.println("Result: " + result);
    }

    static void rectangle(Scanner input) {
        int area, perimeter;
        System.out.print("Enter the length of one edge: ");
        int num1 = input.nextInt();

        System.out.print("Enter the length of the other edge: ");
        int num2 = input.nextInt();

        area = num1 * num2;

        perimeter = 2 * (num1 + num2);

        System.out.println("Area: " + area);
        System.out.println("Perimeter : " + perimeter);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int select;
        String menu = "1- Addition Operation (enter 0 to end operation)\n"
                + "2- Subtraction Operation\n"
                + "3- Multiplication Operation\n"
                + "4- Division Operation\n"
                + "5- Power Calculation\n"
                + "6- Factorial Calculation\n"
                + "7- Modulus Operation\n"
                + "8- Rectangle Area and Perimeter Calculation\n"
                + "0- Exit";

        do {
            System.out.println(menu);
            while (true) {
                try {
                    System.out.print("Please select an operation: ");
                    select = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    input.next();
                }
            }
            switch (select) {
                case 1:

                    plus(input);
                    break;
                case 2:
                    minus(input);
                    break;
                case 3:
                    times(input);
                    break;
                case 4:
                    divided(input);
                    break;
                case 5:
                    power(input);
                    break;
                case 6:
                    factorial(input);
                    break;
                case 7:
                    mod(input);
                    break;
                case 8:
                    rectangle(input);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("You have entered an incorrect value, please try again.");
            }
        } while (select != 0);
    }
}

