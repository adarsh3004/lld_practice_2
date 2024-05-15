package practice.patterns.behavioral_pattern.iterator_pattern.iterator;

import practice.patterns.behavioral_pattern.iterator_pattern.Profile;

import java.util.List;

public class LinkedinIterator implements ProfileIterator {

    private List<Profile> profileList;
    private int currentPosition = 0;

    public LinkedinIterator(List<Profile> profileList) {
        this.profileList = profileList;
    }
    @Override
    public boolean hasNext() {
        return currentPosition < profileList.size();
    }

    @Override
    public Profile getNext() {
        for(int i=currentPosition;i<profileList.size();i++) {
            Profile profile = profileList.get(i);
            if(profile.getActive().equalsIgnoreCase("Y")) {
                currentPosition = i+1;
                return profile;
            }
        }
        currentPosition = profileList.size();
        return null;
    }
}