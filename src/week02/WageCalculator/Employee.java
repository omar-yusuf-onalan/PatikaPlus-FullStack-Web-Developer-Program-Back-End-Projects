package week02.WageCalculator;

public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        double tax;
        if (salary < 1000) {
            tax = 0;
        } else {
            tax = salary * 0.03;
        }
        return tax;
    }

    public int bonus() {
        int bonus;
        if (workHours > 40) {
           bonus = (workHours - 40) * 30;
        } else {
            bonus = 0;
        }
        return bonus;
    }

    public double raiseSalary() {
        double wageIncrease;
        if (2021 - hireYear < 10) {
            wageIncrease = salary * 0.05;
        } else if ((10 <= 2021 - hireYear) && (2021 - hireYear < 20)) {
            wageIncrease = salary * 0.10;
        } else {
            wageIncrease = salary * 0.15;
        }
        return wageIncrease;
    }

    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary + " TL");
        System.out.println("Work Hours: " + workHours);
        System.out.println("Year hired: " + hireYear);
        System.out.println("Tax: " + tax() + " TL");
        System.out.println("Bonuses: " + bonus() + " TL");
        System.out.println("Salary raise: " + raiseSalary() + " TL");
        System.out.println("Net salary: " + (salary + bonus() - tax()) + " TL");
        System.out.println("Gross salary: " + (salary + raiseSalary()) + " TL");
    }
}
