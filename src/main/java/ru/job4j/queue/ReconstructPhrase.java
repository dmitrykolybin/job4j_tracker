package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        int iterations = evenElements.size();
        for (int i = 0; i < iterations; i++) {
            Character element = evenElements.poll();
            if (i % 2 == 0) {
                result.append(element);
            }
        }
        return result.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        int iterations = descendingElements.size();
        for (int i = 0; i < iterations; i++) {
            result.append(descendingElements.pollLast());
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}