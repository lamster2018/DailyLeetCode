import java.util.ArrayList;
import java.util.List;

public class DeadLock {
    public static void main(String[] args) {
        new Consumer().start();
        new Producer().start();
    }

    public static Food food = new Food();

    public static class Food {
        List<String> storage = new ArrayList<>();
    }

    public static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (food) {
                    if (food.storage.isEmpty()) {
                        System.out.println("producer work");
                        for (int i = 0; i < 10; i++) {
                            food.storage.add("food" + i);
                        }
                        System.out.println("producer produce 10 food");
                        food.notify();//换成 food.wait()死锁
                    } else {
                        try {
                            food.wait();
                            System.out.println("producer wait");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (food) {
                    if (food.storage.isEmpty()) {
                        System.out.println("consumer wait");
                        try {
                            food.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        food.storage.clear();
                        food.notify();
                        System.out.println("consumer clear all");
                    }
                }
            }
        }
    }

}
