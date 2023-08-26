package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int currentIndex = indexOf(id);
        boolean isDeletable = currentIndex != -1;
        if (isDeletable) {
            items.remove(currentIndex);
        }
        return isDeletable;
    }

    public boolean replace(int id, Item item) {
        int currentIndex = indexOf(id);
        boolean isReplaceable = currentIndex != -1;
        if (isReplaceable) {
            item.setId(id);
            items.set(currentIndex, item);
        }
        return isReplaceable;
    }

    public List<Item> findByName(String name) {
        List<Item> rsl = new ArrayList<>();
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getName().equals(name)) {
                rsl.add(item);
            }
        }
        return rsl;
    }
}