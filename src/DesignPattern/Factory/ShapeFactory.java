package DesignPattern.Factory;

import javax.lang.model.type.UnknownTypeException;

//定义工厂
public class ShapeFactory {
    public Shape getShape(ShapeType type) {
        switch (type) {
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            default:
                throw new RuntimeException();
        }
    }
}
