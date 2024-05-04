package practice.structural_pattern.adapter_pattern.client_interface;

public class XmlClass implements ClientObject{


    @Override
    public String getString(Object obj) {
        // Do some processing on obj
        return obj.toString();
    }
}
