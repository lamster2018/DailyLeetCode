package DesignPattern.Builder;

public class MacBookBuilder extends ComputerBuilder {
    private Computer computer = new MacBook();

    @Override
    void buildBoard(String board) {
        computer.setBoard(board);
    }

    @Override
    void buildDisplay(String display) {
        computer.setDisplay(display);
    }

    @Override
    void buildOs() {
        computer.setOs();
    }

    @Override
    Computer build() {
        return computer;
    }
}
