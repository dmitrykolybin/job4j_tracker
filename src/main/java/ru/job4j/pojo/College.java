package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Kolybin Dmitry Vadimovich");
        student.setGroup("BMT1-63b");
        student.setDate("20.08.2021");

        System.out.println(student.getName() + " of group "
                + student.getGroup() + " was enrolled " + student.getDate());
    }
}
