package DesignPattern.Proxy;

public class _12306Ticket implements Ticket{

    @Override
    public void buy() {
        System.out.printf("12306 出票");
    }
}
