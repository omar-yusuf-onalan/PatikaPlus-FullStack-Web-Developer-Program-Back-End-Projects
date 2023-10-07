package week05.PatikaStore;

import java.util.*;
import java.util.stream.Collectors;

public class Notebook extends Electronics {
    private static Scanner input = new Scanner(System.in);

    private static LinkedList<Notebook> notebooks = new LinkedList<>();

    public Notebook(int id, Brand brand, String name, double basePrice, double discountRate, int storage, double screenSize, int ram) {
        super(id, brand, name, basePrice, discountRate, storage, screenSize, ram);
    }

    public static void initializeProducts() {
        notebooks.add(new Notebook(1, new Brand("Huawei"), "HUAWEI Matebook 14", 7000, 0, 512, 14, 16));
        notebooks.add(new Notebook(2, new Brand("Lenovo"), "LENOVO V14 IGL", 3699, 0, 1024, 14, 8));
        notebooks.add(new Notebook(3, new Brand("Asus"), "ASUS Tuf Gaming",8199, 0, 2048, 15.6, 32));
    }

    public static void browse() {

        System.out.println("1 - Sort by product ID\n 2- Sort by brand name");
        System.out.print("Which sort setting: ");
        int select = input.nextInt();

        sortNotebooks(select);

        System.out.println("1 - Add product\n 2 - Remove product\n0 - Exit");
        System.out.print("Select an action: ");
        select = input.nextInt();
        input.nextLine();

        switch (select) {
            case 1:
                addProduct();
                break;
            case 2:
                System.out.print("Enter the ID of the product you would like to remove: ");
                int removeId = input.nextInt();
                removeProduct(removeId);
                break;
            default:
                break;
        }
    }

    public static void sortNotebooks(int select) { // uses Stream to sort the Notebook objects in notebooks
        switch (select) {
            case 2:
                printNotebooks(notebooks.stream()
                        .sorted(new BrandComparator())
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
                break;
            default:
                printNotebooks(notebooks.stream()
                        .sorted(new IDComparator())
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
    }

    public static void printNotebooks(LinkedHashSet<Notebook> sortedNotebooks) {
        String separator = "----------------------------------------------------------------------------------------------------";

        System.out.println("List of Notebooks");
        System.out.println(separator);
        System.out.println("| ID | Product Name | Base Price | Discount Rate | Brand | Storage | Screen Size | RAM |");
        System.out.println(separator);

        for (Notebook n : sortedNotebooks) {
            System.out.println("| " + n.getId() + "  | " + n.getName() + " | " + n.getBasePrice() + " | " + n.getDiscountRate() + "| " +
                    n.getBrand().getName() + " | " + n.getStorage() + " | " + n.getScreenSize() + " | " + n.getRam() + " |");
        }

        System.out.println(separator);
    }


    // Other than id, which is generated via another method, this method takes inputs for each parameter of a notebook object,
    // creates a Notebook object, and adds it to notebooks
    public static void addProduct() {
        System.out.println("You have chosen to add a product.");

        int id = determineId();

        System.out.print("Enter brand of product: ");
        String brandName = input.nextLine();
        Brand brand = new Brand(brandName);

        System.out.print("Enter name of product: ");
        String name = input.nextLine();

        System.out.print("Enter base price of product: ");
        double basePrice = input.nextDouble();

        System.out.print("Enter discount rate of product: ");
        double discountRate = input.nextDouble();

        System.out.print("Enter storage capacity of product: ");
        int storage = input.nextInt();

        System.out.print("Enter screen size of product: ");
        double screenSize = input.nextDouble();

        System.out.print("Enter ram capacity of product: ");
        int ram = input.nextInt();

        notebooks.add(new Notebook(id, brand, name, basePrice, discountRate, storage, screenSize, ram));
    }

    public static void removeProduct(int id) { // Removes product using ID
        Notebook toBeRemoved = null;
        for (Notebook notebook : notebooks) {
            if (notebook.getId() == id) {
                toBeRemoved = notebook;
                break;
            }
        }

        if (toBeRemoved != null) { // If there are no more products of the same brand in notebooks or phones, then that brand is removed from brands.
            notebooks.remove(toBeRemoved);
            String brandToBeChecked = toBeRemoved.getBrand().getName();

            boolean brandExistsInNotebooks = notebooks.stream().anyMatch(n -> n.getBrand().getName().equals(brandToBeChecked));
            boolean brandExistsInPhones = Phone.getPhones().stream().anyMatch(p -> p.getBrand().getName().equals(brandToBeChecked));

            if (!brandExistsInNotebooks && !brandExistsInPhones) {
                Brand.getBrands().remove(brandToBeChecked);
            }
        } else {
            System.out.println("Item not found");
        }
    }

    public static int determineId() { // Determines the smallest possible ID for the product starting from 1
        int newId = 1;
        for (Notebook notebook : notebooks) {
            if (notebook.getId() == newId) {
                newId++;
            }
        }
        return newId;
    }

    public static LinkedList<Notebook> getNotebooks() {
        return notebooks;
    }
}
