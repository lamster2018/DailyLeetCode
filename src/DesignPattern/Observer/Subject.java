package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    // 重点就是这个，一定有一个集合来维护，然后遍历通知下去
    protected List<Observer> observerList = new ArrayList<>();

    public void add(Observer observer) {
        observerList.add(observer);
    }

    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    public abstract void notifyObserver();
}
