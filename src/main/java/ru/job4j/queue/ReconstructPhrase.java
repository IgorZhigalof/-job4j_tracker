package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        Iterator<Character> toIterate = evenElements.iterator();
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            if (i % 2 == 0) {
                content.append(toIterate.next());
            } else {
                toIterate.next();
            }
        }
        return content.toString();
    }

    private String getDescendingElements() {
        Iterator<Character> toIterate = descendingElements.descendingIterator();
        StringBuilder content = new StringBuilder();
        while (toIterate.hasNext()) {
            content.append(toIterate.next());
        }
        return content.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}