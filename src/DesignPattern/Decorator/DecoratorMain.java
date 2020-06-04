package DesignPattern.Decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 意图：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 * 主要解决：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。
 * 何时使用：在不想增加很多子类的情况下扩展类。
 * 如何解决：将具体功能职责划分，同时继承装饰者模式。
 * <p>
 * 关键代码： 1、Component 类充当抽象角色，不应该具体实现。
 * 2、修饰类引用和继承 Component 类，具体扩展类重写父类方法。
 * <p>
 * 优点：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
 * <p>
 * 缺点：多层装饰比较复杂。
 * <p>
 * 使用场景： 1、扩展一个类的功能。 2、动态增加功能，动态撤销。
 * <p>
 * Java IO : 流，以及装饰器模式在其上的运用,这个还是看得懂一些
 * https://segmentfault.com/a/1190000004255439
 * <p>
 * 顶级抽象类 inputStream,只提供了read抽象方法
 * BufferedInputStream就是一个装饰者，它能为一个原本没有缓冲功能的InputStream添加上缓冲的功能
 * <p>
 * 这里就是 盲僧没有技能
 * 技能栏 skills类提供了 额外功能
 *
 * 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
public class DecoratorMain {
    public static void main(String[] args) throws FileNotFoundException {
        //选择英雄,被装饰类
        Hero hero = new BlindMonk("李青");
        //技能栏目，额外职责，装饰类
        Skills skills = new Skills(hero);
        SkillQ q = new SkillQ(hero, "q");
        SkillR r = new SkillR(skills, "r");

        q.learnSkills();
        r.learnSkills();

        //fileInputStream是 inputStream的实现类，本来只是一个对read的实现
        // 但是 BufferedInputStream 为 inputStream提供了 缓冲功能，也就是装饰上了
        InputStream inputStream = new BufferedInputStream(new FileInputStream("path"));
    }
}
