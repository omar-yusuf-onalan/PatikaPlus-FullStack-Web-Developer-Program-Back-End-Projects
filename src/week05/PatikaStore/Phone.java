package week05.PatikaStore;

import java.util.*;
import java.util.stream.Collectors;

public class Phone extends Electronics {
    private static Scanner input = new Scanner(System.in);
    private static LinkedList<Phone> phones = new LinkedList<>();
    private int batteryCapacity;
    private String color;

    public Phone(int id, Brand brand, String name, double basePrice, double discountRate, int storage, double screenSize, int ram, int batteryCapacity, String color) {
        super(id, brand, name, basePrice, discountRate, storage, screenSize, ram);
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public static void initializeProducts() {
        phones.add(new Phone(1, new Brand("Samsung"), "SAMSUNG GALAXY A51", 3199.0, 0, 128, 6.5, 32, 4000, "Black"));
        phones.add(new Phone(2, new Brand("Apple"), "iPhone 11 64 GB", 7379.0, 0, 64, 6.1, 5, 3046, "Blue"));
        phones.add(new Phone(3, new Brand("Xiaomi"), "Redmi Note 10 Pro 8GB", 4012.0, 0, 128, 6.5, 35, 4000, "White"));
    }

    public static void browse() {
        System.out.println("1 - Sort by product ID\n2 - Sort by brand name");
        System.out.print("Which sort setting: ");
        int select = input.nextInt();
        input.nextLine();

        sortPhones(select);

        System.out.println("1 - Add product\n2 - Remove product\n0 - Exit");
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

    public static void sortPhones(int select) {
        switch (select) {
            case 2:
                printPhones(phones.stream()
                        .sorted(new BrandComparator())
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
                break;
            default:
                printPhones(phones.stream()
                        .sorted(new IDComparator())
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
    }

    public static void printPhones(LinkedHashSet<Phone> sortedPhones) {
        String separator = "----------------------------------------------------------------------------------------------------";

        System.out.println("List of Phones");
        System.out.println(separator);
        System.out.println("| ID | Product Name | Base Price | Brand | Storage | Screen Size | RAM | Battery | Color |");
        System.out.println(separator);

        for (Phone p : sortedPhones) {
            System.out.println("| " + p.getId() + "  | " + p.getName() + " | " + p.getBasePrice() + " | " +
                    p.getBrand().getName() + " | " + p.getStorage() + " | " + p.getScreenSize() + " | " + p.getRam() + " | " + p.getBatteryCapacity() + " | " + p.getColor() + " |");
        }

        System.out.println(separator);
    }

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

        System.out.print("Enter battery capacity of product: ");
        int batteryCapacity = input.nextInt();

        input.nextLine();
        System.out.print("Enter color of product: ");
        String color = input.nextLine();

        phones.add(new Phone(id, brand, name, basePrice, discountRate, storage, screenSize, ram, batteryCapacity, color));
    }

    public static void removeProduct(int id) {
        Phone toBeRemoved = null;
        for (Phone phone : phones) {
            if (phone.getId() == id) {
                toBeRemoved = phone;
                break;
            }
        }

        if (toBeRemoved != null) {
            phones.remove(toBeRemoved);
            String brandToBeChecked = toBeRemoved.getBrand().getName();

            boolean brandExistsInPhones = phones.stream().anyMatch(p -> p.getBrand().getName().equals(brandToBeChecked));
            boolean brandExistsInNotebooks = Notebook.getNotebooks().stream().anyMatch(n -> n.getBrand().getName().equals(brandToBeChecked));

            if (!brandExistsInPhones && !brandExistsInNotebooks) {
                Brand.getBrands().remove(brandToBeChecked);
            }
        } else {
            System.out.println("Item not found");
        }
    }

    public static int determineId() {
        int newId = 1;
        for (Phone phone : phones) {
            if (phone.getId() == newId) {
                newId++;
            }
        }
        return newId;
    }
    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public static LinkedList<Phone> getPhones() {
        return phones;
    }
}
