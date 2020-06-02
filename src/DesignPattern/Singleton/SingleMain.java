package DesignPattern.Singleton;

public class SingleMain {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingle();
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.equals(singleton1));//这里用了两种不同的单例构造方法，内部都是new
    }
}
