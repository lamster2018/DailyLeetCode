package DesignPattern.Factory;

/**
 * 其实使用反射是一种不错的办法，但反射也是从类名反射而不能从类反射！
 * 先看一下工厂模式是用来干什么的——属于创建模式，解决子类创建问题的。
 * 换句话来说，调用者并不知道运行时真正的类名，只知道从“Circle"可以创建出一个shape接口的类，
 * 至于类的名称是否叫'Circle"，调用者并不知情。
 * 所以真正的对工厂进行扩展的方式（防止程序员调用出错）可以考虑使用一个枚举类（防止传入参数时，把circle拼写错误）。
 * 如果调用者参肯定类型是Circle的话，那么其工厂没有存在的意义了！
 * 比如 IShape shape = new Circle();这样不是更好？也就是说调用者有了Circle这个知识是可以直接调用的，
 * 根据DP（迪米特法则）其实调用者并不知道有一个Circle类的存在，
 * 他只需要知道这个IShape接口可以计算圆面积，而不需要知道{圆}这个类到底是什么类名
 * 他只知道给定一个”circle"字符串的参数,IShape接口可以自动计算圆的面积就可以了！
 * <p>
 * 优点： 1、一个调用者想创建一个对象，只要知道其名称就可以了。
 * 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
 * 3、屏蔽产品的具体实现，调用者只关心产品的接口。
 * <p>
 * 缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，
 * 使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。
 */
public class FactoryMain {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape(ShapeType.CIRCLE);
        shape1.draw();
        Shape shape2 = shapeFactory.getShape(ShapeType.RECTANGLE);
        shape2.draw();
    }
}
