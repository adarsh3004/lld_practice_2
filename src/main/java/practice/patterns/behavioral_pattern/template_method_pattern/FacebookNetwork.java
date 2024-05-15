package practice.patterns.behavioral_pattern.template_method_pattern;


public class FacebookNetwork extends Network {

    public FacebookNetwork(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    @Override
    public boolean validate(String message) {
        System.out.println("Validating message : " + message + " for facebook app");
        if(message == null)
            return false;
        return true;
    }

    @Override
    public void postData(String message) {
        System.out.println("Posting message : " + message + " for facebook app");
    }
}
