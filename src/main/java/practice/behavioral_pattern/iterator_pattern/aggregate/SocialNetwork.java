package practice.behavioral_pattern.iterator_pattern.aggregate;

import practice.behavioral_pattern.iterator_pattern.iterator.ProfileIterator;


public interface SocialNetwork {

    ProfileIterator createIterator();
}
