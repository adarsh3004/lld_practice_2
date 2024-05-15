package practice.patterns.behavioral_pattern.template_method_pattern;

public class WhatsappNetwork extends Network{


    public WhatsappNetwork(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    @Override
    boolean validate(String message) {
        System.out.println("Validating message : " + message + " for whatsapp app");
        if(message == null || message.length() < 5)
            return false;
        return true;
    }

    @Override
    void postData(String message) {
        System.out.println("Posting message : " + message + " for whatsapp app");
    }
}
