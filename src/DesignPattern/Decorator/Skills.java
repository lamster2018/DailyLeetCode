package DesignPattern.Decorator;

//装饰类，技能栏。相当于一个英雄有了加点这个功能，但是具体的技能还不知道
public class Skills implements Hero {
    //持有一个英雄对象接口
    private Hero hero;

    public Skills(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkills() {
        if (hero != null)
            hero.learnSkills();
    }
}
