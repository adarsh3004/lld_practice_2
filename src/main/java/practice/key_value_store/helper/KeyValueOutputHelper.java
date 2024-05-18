package practice.key_value_store.helper;

import practice.key_value_store.model.Value;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class KeyValueOutputHelper {

    public StringBuilder printGetResult(Map.Entry<String, List<Value>> entry) {

        StringBuilder str = new StringBuilder();
        entry.getValue().stream().filter(Objects::nonNull).forEach(vl -> {
            str.append(vl.getAttributeKey());
            str.append(": ");
            str.append(vl.getAttributeValue());
            str.append(", ");
        });
        return str;
    }
}
