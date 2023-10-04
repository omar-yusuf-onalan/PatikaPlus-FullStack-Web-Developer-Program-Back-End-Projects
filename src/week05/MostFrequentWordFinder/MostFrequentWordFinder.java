package week05.MostFrequentWordFinder;

import java.util.*;

public class MostFrequentWordFinder {
    String[] words;
    HashMap<String, Integer> hashMap = new HashMap<>();

    public void inputString() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");

        String str = input.nextLine();

        words = str.split("\\s+"); // Space (" ") is the delimiter

        input.close();
    }

    public void fillHashMap() {
        for (int i = 0; i < words.length; i++) {
            if (hashMap.get(words[i]) != null) { // Already has a value
                hashMap.put(words[i].toLowerCase(), hashMap.get(words[i]) + 1); // So its value will be increased by one
            } else {
                hashMap.put(words[i].toLowerCase(), 1);
            }
        }
    }

    public void printMostFrequentWord() {
        Collection<Integer> values = hashMap.values();
        Collection<String> keys = hashMap.keySet();
        int highestNumber = 0;

        for (int value : values) { // The highest value is determined in this loop
            if (value > highestNumber) {
                highestNumber = value;
            }
        }

        System.out.print("The most frequent word(s) is ");
        for (String key : keys) { // The keys with the highest corresponding value are printed
            if (hashMap.get(key) == highestNumber) {
                System.out.println("\"" + key + "\"" + "(" + highestNumber + ")\t");
            }
        }
    }
}
