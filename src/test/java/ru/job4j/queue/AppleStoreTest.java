package ru.job4j.queue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class AppleStoreTest {
    @Test
    void whenGetLast() {
        Queue<Customer> customers = new LinkedList<>(
                Arrays.asList(
                        new Customer("Petr", 1000), new Customer("Stas", 1500),
                        new Customer("Andrey", 850), new Customer("Alexei", 900),
                        new Customer("Iryna", 1250), new Customer("Elena", 750),
                        new Customer("Rail", 950)

        ));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getLastHappyCustomer();
        assertThat(customer).isEqualTo("Alexei");
    }

    @Test
    void whenGetFirst() {
        Queue<Customer> customers = new LinkedList<>(
                Arrays.asList(
                        new Customer("Petr", 1000), new Customer("Stas", 1500),
                        new Customer("Andrey", 850), new Customer("Alexei", 900),
                        new Customer("Iryna", 1250), new Customer("Elena", 750),
                        new Customer("Rail", 950)

        ));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getFirstUpsetCustomer();
        assertThat(customer).isEqualTo("Iryna");
    }
}