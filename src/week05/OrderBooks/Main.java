package week05.OrderBooks;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> bookTreeSet1 = new TreeSet<>(new OrderBooksByNameComparator());
        Book janeEyre = new Book("Jane Eyre", 680, "Charlotte Brontë", 1847);
        Book paym = new Book("A Portrait of the Artist as a Young Man", 329, "James Joyce", 2003);
        Book dalloway = new Book("Mrs. Dalloway", 194, "Virginia Woolf", 1925);
        Book gwtw = new Book("Gone with the Wind", 1037, "Margaret Mitchell", 1936);
        Book hod = new Book("Heart of Darkness", 188, "Joseph Conrad", 1899);

        bookTreeSet1.add(janeEyre);
        bookTreeSet1.add(paym);
        bookTreeSet1.add(dalloway);
        bookTreeSet1.add(gwtw);
        bookTreeSet1.add(hod);

        System.out.println("Sorted by name: ");
        for(Book book : bookTreeSet1) {
            System.out.println(book.getName());
        }
        System.out.println();

        TreeSet<Book> bookTreeSet2 = new TreeSet<>(new OrderBooksByPageNumberComparator());

        bookTreeSet2.add(janeEyre);
        bookTreeSet2.add(paym);
        bookTreeSet2.add(dalloway);
        bookTreeSet2.add(gwtw);
        bookTreeSet2.add(hod);

        System.out.println("Sorted by number of pages: ");
        for(Book book : bookTreeSet2) {
            System.out.println(book.getNumberOfPages() + " " + book.getName());
        }
    }
}
