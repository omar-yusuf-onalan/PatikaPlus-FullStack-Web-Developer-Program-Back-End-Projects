package week06.Notepad;

import java.io.*;
import java.util.Scanner;

public class Notepad {
    public static void main(String[] args) {
        try {
            File notes = new File("src/week06/Notepad/notes.txt");

            if (!notes.createNewFile()) { // This text only appears if the text file has been created before
                System.out.println("Your previously saved note:\n=====");
            }

            FileReader fileReader = new FileReader(notes);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter a string of text you would like to save: ");
            String text = input.nextLine();

            FileWriter fileWriter = new FileWriter(notes); // add "true" as the second argument to append
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);

            input.close();
            fileWriter.close();
            fileReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
