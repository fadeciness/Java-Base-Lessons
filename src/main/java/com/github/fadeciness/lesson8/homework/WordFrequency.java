package com.github.fadeciness.lesson8.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String bigText = "Чтобы начать изучение Java Stream API, разберём основные определения. В языке Java есть понятие\n" +
                "потоков, но ни классы InputStream (поток ввода) и OutputStream (поток вывода), ни Thread (поток\n" +
                "исполнения) не имеют ничего общего с новшеством Java 8 — Stream API. Stream API работает не с\n" +
                "потоком в прямом смысле слова, а с цепочкой функций, вызываемых из самих себя. Он обеспечивает\n" +
                "функциональное программирование в Java 8. Поток — это последовательность элементов и функций,\n" +
                "которые поддерживают различные виды операций. Чтобы не путаться в понятиях, обозначим Stream\n" +
                "API как стрим.";

        /*String theMostFrequencyWord = */Arrays.stream(bigText.split("\\s"))
                .filter(Objects::nonNull)
                .map(String::trim)
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum))
                .entrySet().stream()
//                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
//                .findFirst()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .ifPresent(w -> System.out.println("Самое часто встречающееся слово: " + w));
//                .orElseThrow(() -> {
//                    throw new RuntimeException("Не найдено ни одного слова");
//                });
//        System.out.println("Самое часто встречающееся слово: " + theMostFrequencyWord);
    }
}
