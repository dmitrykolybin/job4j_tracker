package ru.job4j.collection;
import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("test1@mail.ru", "First");
        map.put("test2@mail.ru", "Second");
        map.put("test3@mail.ru", "Third");
        map.put("test2@mail.ru", "Changed second");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
