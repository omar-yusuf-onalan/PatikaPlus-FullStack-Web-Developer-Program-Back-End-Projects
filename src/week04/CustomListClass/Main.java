package week04.CustomListClass;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        System.out.println("List Status : " + (list.isEmpty() ? "Empty" : "Full"));
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(70);

        System.out.println("List Status : " + (list.isEmpty() ? "Empty" : "Full"));

        // Gives the index of the first occurrence
        System.out.println("Index : " + list.indexOf(20));

        // Returns -1 if it can't find
        System.out.println("Index: " + list.indexOf(100));

        // Gives the index of the last occurrence
        System.out.println("Index : " + list.lastIndexOf(20));

        // Returns the list as an Object[] array
        Object[] array = list.toArray();
        System.out.println("First element of the Object array: " + array[0]);

        // Creates a sublist with type List
        MyList<Integer> subList = list.sublist(0, 3);
        System.out.println(subList.toString());

        // Queries whether the value exists in the list
        System.out.println("Does the list contain the value 20: " + list.contains(20));
        System.out.println("Does the list contain the value 120: " + list.contains(120));

        // Empties the list and resets it to its default size
        list.clear();
        System.out.println(list.toString());

    }
}
