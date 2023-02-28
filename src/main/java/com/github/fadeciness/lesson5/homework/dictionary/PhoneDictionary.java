package com.github.fadeciness.lesson5.homework.dictionary;

import java.util.*;

public class PhoneDictionary {

    private final Map<String, Set<String>> container;

    public PhoneDictionary() {
        this.container = new HashMap<>();
    }

    public PhoneDictionary(Map<String, Set<String>> container) {
        this.container = container;
    }

    public void add(String surname, String tel) {
        Set<String> telephones = container.getOrDefault(surname, new HashSet<>());
        telephones.add(tel);
        container.put(surname, telephones);
    }

    public void add(String surname, String... tels) {
        Set<String> telephones = container.getOrDefault(surname, new HashSet<>());
        telephones.addAll(Arrays.asList(tels));
        container.put(surname, telephones);
    }

    public Set<String> get(String surname) {
        return container.get(surname);
    }

}
