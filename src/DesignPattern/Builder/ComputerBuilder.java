package DesignPattern.Builder;

//抽象builder
public abstract class ComputerBuilder {
    abstract void buildBoard(String board);

    abstract void buildDisplay(String display);

    abstract void buildOs();

    abstract Computer build();
}
