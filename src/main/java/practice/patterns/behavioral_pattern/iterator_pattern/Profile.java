package practice.patterns.behavioral_pattern.iterator_pattern;

public class Profile {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }


    private String username;
    private String email;
    private String gender;
    private String active;

    public Profile(String username, String email, String gender,String active) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.active = active;
    }

    public Profile clone(Profile profile) {
        return new Profile(profile.getUsername(),profile.getEmail(),profile.getGender(),profile.getActive());
    }

}
