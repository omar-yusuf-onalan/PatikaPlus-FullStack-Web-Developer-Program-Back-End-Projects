package week02.WageCalculator;

// Maaş Hesaplayıcı

public class Main {
    /*
    Employee is a wage calculating class that takes name, salary, workHours, and hireYear as its parameters and
    calculates wage based on various factors. You can find the exact details in Employee.java. This is a
    relatively easy assignment that does not require much explanation.
    */
    public static void main(String[] args) {
        Employee kemal = new Employee("Kemal", 2000, 45, 1985);
        kemal.getInfo();
    }
}
