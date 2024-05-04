package practice.creational_patterm.factory_pattern;

public class CircleShapeFactory implements ShapeFactory{
    @Override
    public Shape create() {
        return new Circle();
    }
}
