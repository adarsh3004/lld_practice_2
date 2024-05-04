package practice.structural_pattern.adapter_pattern;

import practice.structural_pattern.adapter_pattern.adaptee.JsonClass;
import practice.structural_pattern.adapter_pattern.client_interface.ClientObject;

public class JsonToXmlAdapter implements ClientObject {

    JsonClass jsonClass;

    public JsonToXmlAdapter(JsonClass jsonClass) {
        this.jsonClass = jsonClass;
    }

    @Override
    public String getString(Object obj) {
        return jsonClass.getString(obj);
    }
}
