package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("The bus is moving...");
    }

    @Override
    public void showPassengers(int number) {
        System.out.println("There are " + number + " passengers in the bus.");
    }

    @Override
    public double fillUp(int fuel) {
        return fuel * 53.26;
    }
}
