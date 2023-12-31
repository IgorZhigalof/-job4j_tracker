package ru.job4j.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0);

    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.name(), averageScore(Stream.of(x))))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparingInt(x -> (int) x.score()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, HashMap::new, Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(Comparator.comparingInt(x -> (int) x.score()))
                .orElse(null);
    }
}