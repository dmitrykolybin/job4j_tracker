package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String firstLeft = left.split("/")[0];
        String firstRight = right.split("/")[0];
        return firstRight.compareTo(firstLeft) == 0 ? left.compareTo(right) : firstRight.compareTo(firstLeft);
    }
}