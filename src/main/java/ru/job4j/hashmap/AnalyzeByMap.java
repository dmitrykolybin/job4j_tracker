package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalResult = 0;
        double totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalResult += subject.score();
                totalSubjects++;
            }
        }
        return totalResult / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalResult = 0;
            double totalSubjects = 0;
            for (Subject subject : pupil.subjects()) {
                totalResult += subject.score();
                totalSubjects++;
            }
            result.add(new Label(pupil.name(), totalResult / totalSubjects));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Double> totalSubjects = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Double score = totalSubjects.getOrDefault(subject.name(), 0.0) + subject.score();
                totalSubjects.put(subject.name(), score);
            }
        }
        for (String subject : totalSubjects.keySet()) {
            result.add(new Label(subject, totalSubjects.get(subject) / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalResult = 0;
            for (Subject subject : pupil.subjects()) {
                totalResult += subject.score();
            }
            result.add(new Label(pupil.name(), totalResult));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Double> totalSubjects = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Double score = totalSubjects.getOrDefault(subject.name(), 0.0) + subject.score();
                totalSubjects.put(subject.name(), score);
            }
        }
        for (String subject : totalSubjects.keySet()) {
            result.add(new Label(subject, totalSubjects.get(subject)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}