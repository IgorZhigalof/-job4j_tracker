package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenSeveralValidInput() {
        String[] toCheck = new String[] {"2", "1", "3", "6", "9", "4"};
        Output out = new StubOutput();
        Input in = new StubInput(toCheck);
        ValidateInput input = new ValidateInput(out, in);
        int[] result = new int[toCheck.length];
        for (int i = 0; i < toCheck.length; i++) {
            result[i] = input.askInt("Enter menu:");
        }
        assertThat(result).isEqualTo(new int[] {2, 1, 3, 6, 9, 4});
    }

    @Test
    public void whenMinus1InputThenMinus1() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}