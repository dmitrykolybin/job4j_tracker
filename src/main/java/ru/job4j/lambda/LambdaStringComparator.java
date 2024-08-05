package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaStringComparator {
    public static void main(String[] args) {
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Comparator<String> comparatorDescSize = (left, right) -> right.compareTo(left);
        List<String> text = Arrays.asList(
                "test2", "test1", "test3"
        );
        text.sort(comparatorText);
        System.out.println(text);
        text.sort(comparatorDescSize);
        System.out.println(text);
    }
}
