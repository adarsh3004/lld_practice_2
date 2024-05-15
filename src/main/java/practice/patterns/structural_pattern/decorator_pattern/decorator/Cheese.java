package practice.patterns.structural_pattern.decorator_pattern.decorator;

import practice.patterns.structural_pattern.decorator_pattern.base.PizzaComponent;

public class Cheese extends ToppingsDecorator{

    PizzaComponent pizzaComponent;

    public Cheese(PizzaComponent pizzaComponent) {
        this.pizzaComponent = pizzaComponent;
    }

    @Override
    public String getDescription() {
        return pizzaComponent.getDescription() + " with cheese";
    }

    @Override
    public float getCost() {
        return pizzaComponent.getCost() + 20;
    }
}
