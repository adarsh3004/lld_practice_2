package practice.patterns.creational_patterm.factory_pattern;

public class TriangleShapeFactory implements ShapeFactory{
    @Override
    public Shape create() {
        return new Triangle();
    }
}
