package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int result = comparator.compare(
                new Job("Test2", 2),
                new Job("Test1", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int result = comparator.compare(
                new Job("Test2", 2),
                new Job("Test1", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int result = comparator.compare(
                new Job("Test2", 2),
                new Job("Test1", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int result = comparator.compare(
                new Job("Test2", 2),
                new Job("Test1", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        Job a = new Job("Impl task", 0);
        Job b = new Job("Fix bug", 1);
        Job c =  new Job("Fix bug", 2);
        Job d = new Job("Make something", 3);
        List<Job> jobs = Arrays.asList(a, b, d, c);
        List<Job> expected = Arrays.asList(c, b, a, d);
        Collections.sort(jobs, cmpNamePriority);
        assertThat(jobs).isEqualTo(expected);
    }
}