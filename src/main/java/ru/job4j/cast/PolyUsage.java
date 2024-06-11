package ru.job4j.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane1 = new Plane();
        Vehicle train1 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle plane2 = new Plane();
        Vehicle train2 = new Train();
        Vehicle bus2 = new Bus();
        Vehicle plane3 = new Plane();
        Vehicle train3 = new Train();
        Vehicle bus3 = new Bus();
        Vehicle[] vehicles = new Vehicle[] {plane1, bus1, train1,
                                            plane2, bus2, train2,
                                            plane3, bus3, train3};
        for (Vehicle object : vehicles) {
            object.move();
        }
    }
}
