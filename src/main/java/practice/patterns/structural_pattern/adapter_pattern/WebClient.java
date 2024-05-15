package practice.patterns.structural_pattern.adapter_pattern;

import practice.patterns.structural_pattern.adapter_pattern.client_interface.ClientObject;

public class WebClient {

    ClientObject clientObject;

    public WebClient(ClientObject clientObject) {
        this.clientObject = clientObject;
    }

    public String getValueOfObject(Object obj) {
        return clientObject.getString(obj);
    }
}
