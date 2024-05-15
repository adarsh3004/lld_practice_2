package practice.patterns.structural_pattern.adapter_pattern.adaptee;

public class JsonClass {

    public JsonClass() {}


    public String getString(Object obj) {
        String str = "";
        if(obj instanceof String) {
            str = obj.toString() + " Adpated";
        }
        return str;
    }

}
