package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaStringComparator {
    public static void main(String[] args) {
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Comparator<String> comparatorDescSize = (left, right) ->
                Integer.compare(right.length(), left.length());
        List<String> text = Arrays.asList(
                "test222", "test1", "test33"
        );
        text.sort(comparatorText);
        System.out.println(text);
        text.sort(comparatorDescSize);
        System.out.println(text);
    }
}
