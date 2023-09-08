package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        double subjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                subjects++;
            }
        }
        return score / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        ArrayList<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            double subjects = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                subjects++;
            }
            result.add(
                    new Label(
                            pupil.name(),
                            (score / subjects)
                    )
            );
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        HashMap<String, Integer> totalScore = getSubjectsWithTotalScore(pupils);
        ArrayList<Label> result = new ArrayList<>();
        for (String key : totalScore.keySet()) {
            result.add(
                    new Label(
                            key,
                            (double) totalScore.get(key) / pupils.size()
                    )
            );
        }
        return result;
    }

    private static HashMap<String, Integer> getSubjectsWithTotalScore(List<Pupil> pupils) {
        HashMap<String, Integer> totalScore = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore.put(subject.name(), totalScore.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        return totalScore;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        ArrayList<Label> pupilsWithScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            pupilsWithScore.add(
                    new Label(
                            pupil.name(),
                            (score)
                    )
            );
        }
        pupilsWithScore.sort(Comparator.naturalOrder());
        return pupilsWithScore.get(pupilsWithScore.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        HashMap<String, Integer> totalScore = getSubjectsWithTotalScore(pupils);
        ArrayList<Label> result = new ArrayList<>();
        for (String key : totalScore.keySet()) {
            result.add(
                    new Label(
                            key,
                            totalScore.get(key)
                    )
            );
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}