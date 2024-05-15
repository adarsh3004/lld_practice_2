package practice.patterns.behavioral_pattern.iterator_pattern.aggregate;

import practice.patterns.behavioral_pattern.iterator_pattern.Profile;
import practice.patterns.behavioral_pattern.iterator_pattern.iterator.LinkedinIterator;
import practice.patterns.behavioral_pattern.iterator_pattern.iterator.ProfileIterator;

import java.util.List;

public class Linkedin implements SocialNetwork{

    private List<Profile> profileList;

    public Linkedin(List<Profile> profileList) {
        this.profileList = profileList;
    }

    @Override
    public ProfileIterator createIterator() {
        return new LinkedinIterator(profileList);
    }

    // Other methods here
}
