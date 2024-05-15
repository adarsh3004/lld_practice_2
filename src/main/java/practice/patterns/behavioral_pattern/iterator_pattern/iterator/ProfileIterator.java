package practice.patterns.behavioral_pattern.iterator_pattern.iterator;

import practice.patterns.behavioral_pattern.iterator_pattern.Profile;

public interface ProfileIterator {

    boolean hasNext();
    Profile getNext();
}