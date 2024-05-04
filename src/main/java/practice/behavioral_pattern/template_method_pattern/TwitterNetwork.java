package practice.behavioral_pattern.template_method_pattern;

public class TwitterNetwork extends Network{

    public TwitterNetwork(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    @Override
    boolean validate(String message) {
        System.out.println("Validating message : " + message + " for twitter app");
        if(message == null || message.contains("#"))
            return false;
        return true;
    }

    @Override
    void postData(String message) {
        System.out.println("Posting message : " + message + " for twitter app");
    }

    public void login(String username, String pwd) {
        System.out.println("Logging in with twitter login process with username = " + username + " and password = " + pwd);
    }
}
