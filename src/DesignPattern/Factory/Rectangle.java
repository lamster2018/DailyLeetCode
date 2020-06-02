package DesignPattern.Factory;

//定义实际产品
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println(this.getClass().getName());
    }
}
