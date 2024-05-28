package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int divide(int c) {
        return x / c;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("+ " + result);
        result = minus(5);
        System.out.println("- " + result);
        Calculator calculator = new Calculator();
        result = calculator.multiply(5);
        System.out.println("* " + result);
        result = calculator.divide(5);
        System.out.println("/ " + result);
        result = calculator.sumAllOperation(5);
        System.out.println("ALL " + result);
    }
}