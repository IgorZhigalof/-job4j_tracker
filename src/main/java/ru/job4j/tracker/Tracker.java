package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean delete(int id) {
        int currentIndex = -1;
        if (id >= 0 && id <= size) {
            currentIndex = indexOf(id);
        }
        if (currentIndex != -1) {
            System.arraycopy(items, currentIndex + 1, items, currentIndex, size - currentIndex - 1);
            items[size - 1] = null;
            size--;
        }
        return currentIndex != -1;
    }

    public boolean replace(int id, Item item) {
        int currentIndex = -1;
        if (id >= 0 && id <= size) {
            currentIndex = indexOf(id);
        }
        if (currentIndex != -1) {
            item.setId(id);
            items[currentIndex] = item;
        }
        return currentIndex != -1;
    }

    public Item[] findByName(String name) {
        Item[] rsl = new Item[size];
        int counter = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(name)) {
                rsl[counter] = item;
                counter++;
            }
        }
        return Arrays.copyOf(rsl, counter);
    }
}