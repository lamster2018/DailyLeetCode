package DesignPattern.Observer;

public class RealSubject extends Subject {

    @Override
    public void notifyObserver() {
        for (Observer o : observerList) {
            o.response();
        }
    }
}
