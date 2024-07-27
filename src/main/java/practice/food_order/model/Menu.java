package practice.food_order.model;

import lombok.ToString;

import java.util.List;

@ToString
public class Menu {

    private String name;
    private List<Item> itemList;

    public Menu(String name, List<Item> itemList) {
        this.name = name;
        this.itemList = itemList;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
