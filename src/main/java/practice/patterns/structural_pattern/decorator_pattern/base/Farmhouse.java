package practice.patterns.structural_pattern.decorator_pattern.base;

public class Farmhouse extends PizzaComponent {


    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

    @Override
    public float getCost() {
        return 200;
    }
}
