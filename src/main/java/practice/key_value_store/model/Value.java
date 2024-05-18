package practice.key_value_store.model;

public class Value {

    private String attributeKey;
    private Object attributeValue;

    public Value(String attributeKey, Object attributeValue) {
        this.attributeKey = attributeKey;
        this.attributeValue = attributeValue;
    }

    public String getAttributeKey() {
        return attributeKey;
    }

    public Object getAttributeValue() {
        return attributeValue;
    }
}
