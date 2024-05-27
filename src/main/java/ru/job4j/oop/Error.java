package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error: " + active);
        System.out.println("Status is: " + status);
        System.out.println("Description: " + message);
    }

    public static void main(String[] args) {
        Error noError = new Error();
        Error error404 = new Error(true, 404, "The requested resource could not be found");
        noError.printInfo();
        error404.printInfo();
    }
}
