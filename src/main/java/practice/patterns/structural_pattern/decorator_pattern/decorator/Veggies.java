package practice.patterns.structural_pattern.decorator_pattern.decorator;

import practice.patterns.structural_pattern.decorator_pattern.base.PizzaComponent;

public class Veggies extends ToppingsDecorator{

    PizzaComponent pizzaComponent;

    public Veggies(PizzaComponent pizzaComponent) {
        this.pizzaComponent = pizzaComponent;
    }

    @Override
    public String getDescription() {
        return pizzaComponent.getDescription() + " with Veggies";
    }

    @Override
    public float getCost() {
        return pizzaComponent.getCost() + 40;
    }
}
