package week07.PatikaClone.com.patikadev.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student extends User {
    public static ArrayList<Integer> addedPathways = new ArrayList<>();

    public Student(int id, String name, String username, String password, String type) {
        super(id, name, username, password, type);
        ArrayList<AddedPathway> list = AddedPathway.searchAddedPathwayList(getId());

        for (int i = 0; i < list.size(); i++) {
            addedPathways.add(list.get(i).getPathway_id());
        }
    }
}
