package practice.behavioral_pattern.template_method_pattern;


public class FacebookNetwork extends Network {

    @Override
    boolean validate(String message) {
        System.out.println("Validating message : " + message + " for facebook app");
        if(message == null)
            return false;
        return true;
    }

    @Override
    void postData(String message) {
        System.out.println("Posting message : " + message + " for facebook app");
    }
}
