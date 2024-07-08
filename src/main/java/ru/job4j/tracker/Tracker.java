package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        int result = -1;
        int index = 0;
        for (Item item : items) {
            if (item.getId() == id) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item updateItem) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            updateItem.setId(id);
            items.set(index, updateItem);
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }
}