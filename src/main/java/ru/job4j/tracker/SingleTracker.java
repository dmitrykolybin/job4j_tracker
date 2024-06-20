package ru.job4j.tracker;

import java.util.Arrays;

public final class SingleTracker {
    private Tracker tracker;
    private static SingleTracker singleTracker;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item updateItem) {
        return tracker.replace(id, updateItem);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}