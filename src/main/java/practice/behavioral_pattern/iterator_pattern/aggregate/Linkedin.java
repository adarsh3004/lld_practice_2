package practice.behavioral_pattern.iterator_pattern.aggregate;

import practice.behavioral_pattern.iterator_pattern.Profile;
import practice.behavioral_pattern.iterator_pattern.iterator.LinkedinIterator;
import practice.behavioral_pattern.iterator_pattern.iterator.ProfileIterator;

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
