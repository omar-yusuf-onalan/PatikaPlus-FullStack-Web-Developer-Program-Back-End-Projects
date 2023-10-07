package week05.PatikaStore;

import java.util.TreeSet;

public class Brand implements Comparable<String> {
    private static TreeSet<String> brands = new TreeSet<>();
    private String name;

    public Brand(String name) {
        this.name = name;
        addToBrands(name);
    }

    @Override
    public int compareTo(String otherBrand) {
        return this.name.compareTo(otherBrand);
    }

    public static void addToBrands(String name) {
        brands.add(name);
    }

    public static void printBrands() {
        System.out.println("==========");
        System.out.println("Brands: ");

        for (String brand : brands) {
            System.out.println("- " + brand);
        }
    }

    public static TreeSet<String> getBrands() {
        return brands;
    }

    public static void setBrands(TreeSet<String> brands) {
        Brand.brands = brands;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
