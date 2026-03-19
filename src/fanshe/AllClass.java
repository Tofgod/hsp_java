package fanshe;

import java.io.Serializable;

public class AllClass {
    public static void main(String[] args) {

        Class<String> stringClass = String.class;
        Class<Serializable> serializableClass = Serializable.class;
        Class<int[]> aClass = int[].class;

        Class<Deprecated> deprecatedClass = Deprecated.class;

        Class<Void> voidClass = void.class;

        Class<Thread.State> stateClass = Thread.State.class;

        Class<Class> classClass = Class.class;

        // 在编译的时候记载这个类 就是 静态加载
        //动态加载 在运行的时候加载这个类 如果没有用到这个类 则不会报错
    }
}
