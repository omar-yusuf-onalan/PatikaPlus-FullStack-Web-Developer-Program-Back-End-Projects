package week05.PatikaStore;

import java.util.Comparator;

public class IDComparator implements Comparator<Electronics> {
    public int compare(Electronics e1, Electronics e2) {
        return Integer.compare(e1.getId(), e2.getId());
    }
}
