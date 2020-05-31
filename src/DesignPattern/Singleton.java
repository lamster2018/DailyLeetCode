package DesignPattern;

/**
 * 1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例。
 * 3、单例类必须给所有其他对象提供这一实例。
 * 优点：
 * 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。
 * 2、避免对资源的多重占用（比如写文件操作）。
 * 缺点：没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
 */
public class Singleton {
    // 枚举
//    public enum Singleton {
//        INSTANCE;
//        public void whateverMethod() {
//        }
//    }
    private volatile static Singleton single;

    private Singleton() {

    }

    public static Singleton getSingle() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }

    /**
     * 利用了 classloader 机制来保证初始化 instance 时只有一个线程，
     * 它跟饿汉式方式不同的是：饿汉式方式只要 Singleton 类被装载了，
     * 那么 instance 就会被实例化（没有达到 lazy loading 效果），
     * 而这种方式是 Singleton 类被装载了，instance 不一定被初始化。
     * 因为 SingletonHolder 类没有被主动使用，
     * 只有通过显式调用 getInstance 方法时，
     * 才会显式装载 SingletonHolder 类，从而实例化 instance。
     * 想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，
     * 另外一方面，又不希望在 Singleton 类加载时就实例化，
     * 因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，
     * 那么这个时候实例化 instance 显然是不合适的。
     * 这个时候，这种方式相比饿汉式方式就显得很合理。
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
