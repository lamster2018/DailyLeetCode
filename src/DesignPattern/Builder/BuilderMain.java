package DesignPattern.Builder;

public class BuilderMain {
    public static void main(String[] args) {
        ComputerBuilder builder = new MacBookBuilder();
        Director director = new Director(builder);
        //指挥者内部完成了组装
        director.construct("apple", "retina");
        Computer computer = builder.build();
        System.out.println(computer.toString());
    }
}
