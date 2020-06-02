package DesignPattern.Builder;

//指挥者，简单建造的时候，是可以省略的
public class Director {
    private ComputerBuilder computerBuilder = null;

    public Director(ComputerBuilder builder) {
        this.computerBuilder = builder;
    }

    public void construct(String board, String display) {
        computerBuilder.buildDisplay(display);
        computerBuilder.buildBoard(board);
        computerBuilder.buildOs();
    }
}
