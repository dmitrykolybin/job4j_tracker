package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            String result = "";
            for (String element : value.split("/")) {
                result = (result.isEmpty()) ? element : result + "/" + element;
                temp.add(result);
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}