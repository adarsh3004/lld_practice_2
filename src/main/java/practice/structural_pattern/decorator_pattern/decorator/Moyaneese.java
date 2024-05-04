package practice.structural_pattern.decorator_pattern.decorator;

import practice.structural_pattern.decorator_pattern.base.PizzaComponent;

public class Moyaneese extends ToppingsDecorator{

    PizzaComponent pizzaComponent;

    public Moyaneese(PizzaComponent pizzaComponent) {
        this.pizzaComponent = pizzaComponent;
    }

    @Override
    public String getDescription() {
        return pizzaComponent.getDescription() + " , Moyaneese";
    }

    @Override
    public float getCost() {
        return pizzaComponent.getCost() + 30;
    }
}
