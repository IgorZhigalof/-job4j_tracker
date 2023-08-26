package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        Queue<Character> queue = new LinkedList<>(evenElements);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            if (i % 2 == 0) {
                content.append(queue.poll());
            } else {
                queue.poll();
            }
        }
        return content.toString();
    }

    private String getDescendingElements() {
        Deque<Character> deque = new LinkedList<>(descendingElements);
        StringBuilder content = new StringBuilder();
        while (deque.peek() != null) {
            content.append(deque.pollLast());
        }
        return content.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}