package DesignPattern.Decorator;

//具体实现类,现在只有简单的构造方法和接口方法，也就是只会平A
public class BlindMonk implements Hero {
    private String name;

    public BlindMonk(String name) {
        this.name = name;
    }

    @Override
    public void learnSkills() {
        System.out.println(name + "学习了以上技能！");
    }
}
