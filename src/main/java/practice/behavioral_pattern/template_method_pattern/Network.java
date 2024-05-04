package practice.behavioral_pattern.template_method_pattern;

public abstract class Network {

    String username;
    String pwd;

    final void post(String message) {
        login(username,pwd);
        if(validate(message)) {
            postData(message);
        }
        logout(username);
    }

    void login(String username, String pwd) {
        System.out.println("Logging in with default login process with username = " + username + " and password = " + pwd);
    }

    abstract boolean validate(String message);
    abstract void postData(String message);

    void logout(String username) {
        System.out.println("Logging out with default logout process, username = " + username);
    }
}
