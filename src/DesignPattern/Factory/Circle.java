package DesignPattern.Factory;

//定义实际产品类
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println(this.getClass().getName());
    }
}
