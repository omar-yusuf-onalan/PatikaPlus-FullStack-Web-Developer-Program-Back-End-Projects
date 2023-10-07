package week05.PatikaStore;

import java.util.Scanner;

public class PatikaStore {
    Scanner input = new Scanner(System.in);

    public void run() {

        // These two methods initialize the default Notebook and Phone products
        // Notebook and Phone works exactly the same, so Phone will not have any comments
        Notebook.initializeProducts();
        Phone.initializeProducts();

        boolean isActive = true;
        while (isActive) {
            System.out.println("1 - Browse Notebooks\n2 - Browse Phones\n3 - Display Brands\n0 - Exit");
            System.out.print("What would you like to do: ");
            int choice = input.nextInt();

            switch (choice) {
                case 0:
                    // Exit app
                    isActive = false;
                    break;
                case 1:
                    // Browse Notebooks
                    Notebook.browse();
                    break;
                case 2:
                    // Browse Phones
                    Phone.browse();
                    break;
                default:
                    // Display Brands
                    Brand.printBrands();
            }
        }
    }
}
