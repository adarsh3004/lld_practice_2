package practice.structural_pattern.decorator_pattern.base;


public class ShicagoPizza extends PizzaComponent {

    @Override
    public String getDescription() {
        return "Shicago Pizza";
    }

    @Override
    public float getCost() {
        return 300;
    }
}
