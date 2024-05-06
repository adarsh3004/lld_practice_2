package practice.behavioral_pattern.iterator_pattern.aggregate;

import practice.behavioral_pattern.iterator_pattern.Profile;
import practice.behavioral_pattern.iterator_pattern.iterator.FacebookIterator;
import practice.behavioral_pattern.iterator_pattern.iterator.ProfileIterator;

import java.util.List;

public class Facebook implements SocialNetwork{

    private List<Profile> profileList;

    public Facebook(List<Profile> profileList) {
        this.profileList = profileList;
    }

    @Override
    public ProfileIterator createIterator() {
        return new FacebookIterator(profileList);
    }

    // Other methods here
}