package DesignPattern.Proxy;

public class TicketProxy implements Ticket {
    private _12306Ticket m12306Ticket;

    public TicketProxy(_12306Ticket real) {
        m12306Ticket = real;
    }

    @Override
    public void buy() {
        System.out.println("代售点出票");
        m12306Ticket.buy();
    }
}
