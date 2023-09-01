package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    public void whenDescByName() {
        Item a = new Item("a");
        Item b = new Item("b");
        Item d = new Item("d");
        Item c = new Item("c");
        List<Item> items = Arrays.asList(
                c, a, d, b
        );
        List<Item> expected = Arrays.asList(
                d, c, b, a
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}