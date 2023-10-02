package week05.OrderBooks;

public class Book {
    String name;
    int numberOfPages;
    String author;
    int publishedYear;

    public Book(String name, int numberOfPages, String author, int publishedYear) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.author= author;
        this.publishedYear = publishedYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
