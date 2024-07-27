package practice.food_order.model;

import lombok.ToString;

@ToString
public class Restaurant {

    private String name;
    private Long maxCapacity;
    private Long usedCapacity;
    private Menu menu;

    public Restaurant(String name, Long maxCapacity, Menu menu) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.menu = menu;
        this.usedCapacity = 0L;
    }

    public String getName() {
        return name;
    }

    public Long getMaxCapacity() {
        return maxCapacity;
    }

    public Long getUsedCapacity() {
        return usedCapacity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setUsedCapacity(Long usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
