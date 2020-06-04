package DesignPattern.Observer;

public class RealObserver implements Observer {
    private String name;

    public RealObserver(String name) {
        this.name = name;
    }

    @Override
    public void response() {
        System.out.println(name + " responsed");
    }
}
