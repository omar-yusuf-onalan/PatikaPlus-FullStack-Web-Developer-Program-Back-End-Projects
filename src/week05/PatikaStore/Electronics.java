package week05.PatikaStore;

public abstract class Electronics {
    private int id;
    private Brand brand;
    private String name;
    private double basePrice;
    private double discountRate;
    private int storage;
    private double screenSize;
    private int ram;

    public Electronics(int id, Brand brand, String name, double basePrice, double discountRate, int storage, double screenSize, int ram) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.basePrice = basePrice;
        this.discountRate = discountRate;
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
