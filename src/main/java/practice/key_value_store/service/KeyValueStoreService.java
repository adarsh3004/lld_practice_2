package practice.key_value_store.service;

import org.springframework.util.CollectionUtils;
import practice.key_value_store.exception.InvalidKeyException;
import practice.key_value_store.helper.KeyValueOutputHelper;
import practice.key_value_store.model.Value;

import java.util.*;

public class KeyValueStoreService {

    private Map<String,List<Value>> keyValues;
    private KeyValueOutputHelper keyValueOutputHelper;

    public KeyValueStoreService() {
        this.keyValues = new HashMap<>();
        this.keyValueOutputHelper = new KeyValueOutputHelper();
    }

    public String get(String key) throws InvalidKeyException {
        for(Map.Entry<String,List<Value>> mp : keyValues.entrySet()) {
            if(Objects.nonNull(mp) && key.equals(mp.getKey())) {
                return keyValueOutputHelper.printGetResult(mp).toString();
            }
        }
        throw new InvalidKeyException("No entry found for");
    }

    public List<String> search(String attributeKey, Object attributeValue) {
        List<String> searchResult = new ArrayList<>();
        keyValues.forEach((key, value) -> {
            if (!CollectionUtils.isEmpty(value)) {
                if (value.stream().anyMatch(vl -> Objects.nonNull(vl) && attributeKey.equals(vl.getAttributeKey()) && attributeValue.equals(vl.getAttributeValue()))) {
                    searchResult.add(key);
                }
            }
        });
        return searchResult;
    }


    public void put(String key, List<Value> attributes) {
        List<Value> lst;
        if(keyValues.containsKey(key))
            lst = keyValues.get(key);
        else
            lst = new ArrayList<>();

        lst.addAll(attributes);
        keyValues.put(key,lst);
    }

    public void delete(String key) {
        if(!keyValues.isEmpty())
           keyValues.remove(key);
    }


    public String keys() {
        StringBuilder str = new StringBuilder();
        keyValues.forEach((key, value) -> {
            str.append(key);
            str.append(",");
        });
        return str.toString();
    }
}
