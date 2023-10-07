package week05.PatikaStore;

import java.util.Comparator;

public class BrandComparator implements Comparator<Electronics> {
    public int compare(Electronics e1, Electronics e2) {
        return e1.getBrand().getName().compareTo(e2.getBrand().getName());
    }
}