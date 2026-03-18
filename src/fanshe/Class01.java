package fanshe;

public class Class01 {
    public static void main(String[] args) {
        // Class 特点梳理
        // Class 不是牛new出来的 是系统创建的  通过 类加载器 ClassLoader类的loaderClass 创建出来的  类的价值只会有一次
        //

        Cat cat = new Cat();
        try {
            Class<?> aClass = Class.forName("fanshe.Cat");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
