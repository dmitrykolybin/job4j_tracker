package ru.job4j.pojo;

public class Library {
    public static void print(Book[] library) {
        for (Book book : library) {
            System.out.println("Book: " + book.getName() + " (" + book.getPages() + " pages)");
        }
        System.out.println();
    }

    public static void print(Book[] library, String name) {
        for (Book book : library) {
            if (book.getName().equals(name)) {
                System.out.println("Book: " + book.getName() + " (" + book.getPages() + " pages)");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Book theShining = new Book("The Shining", 447);
        Book christine = new Book("Christine", 526);
        Book petSematary = new Book("Pet Sematary", 416);
        Book it = new Book("It", 1142);
        Book cleanCode = new Book("Clean Code", 464);
        Book[] library = {theShining, christine, petSematary, it, cleanCode};
        print(library);
        library[0] = it;
        library[3] = theShining;
        print(library);
        print(library, "Clean Code");

    }
}
