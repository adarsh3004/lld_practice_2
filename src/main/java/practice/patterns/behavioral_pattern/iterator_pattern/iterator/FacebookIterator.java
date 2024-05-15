package practice.patterns.behavioral_pattern.iterator_pattern.iterator;

import practice.patterns.behavioral_pattern.iterator_pattern.Profile;

import java.util.List;

public class FacebookIterator implements ProfileIterator {

    private List<Profile> profileList;
    private int currentPosition = 0;

    public FacebookIterator(List<Profile> profileList) {
        this.profileList = profileList;
    }
    @Override
    public boolean hasNext() {
        return currentPosition < profileList.size();
    }

    @Override
    public Profile getNext() {
        return profileList.get(currentPosition++);
    }
}