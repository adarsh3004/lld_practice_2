package practice.food_order.service;

import org.springframework.util.CollectionUtils;
import practice.food_order.model.Item;
import practice.food_order.model.Menu;

import java.util.List;
import java.util.Objects;

public class MenuService {

    public Menu createMenu(String name,List<Item> itemList) {
        return new Menu(name,itemList);
    }

    public Menu updateMenu(Menu menu, List<Item> itemList) {
        if(Objects.nonNull(menu) && !CollectionUtils.isEmpty(menu.getItemList())) {
            List<Item> items = menu.getItemList();
            items.addAll(itemList);
            menu.setItemList(items);
        }
        return menu;
    }

}
