package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FactTest {
    @Test
    void whenMinus1ThenException() {
        Fact fact = new Fact();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    fact.calc(-1);
                }
                );
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    void when2Then2() {
        Fact fact = new Fact();
        int out = fact.calc(2);
        int expected = 2;
        assertThat(out).isEqualTo(expected);
    }
}