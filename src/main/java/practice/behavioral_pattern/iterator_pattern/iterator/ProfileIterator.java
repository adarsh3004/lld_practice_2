package practice.behavioral_pattern.iterator_pattern.iterator;

import practice.behavioral_pattern.iterator_pattern.Profile;

public interface ProfileIterator {

    boolean hasNext();
    Profile getNext();
}