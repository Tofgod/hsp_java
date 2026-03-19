package fanshe;

public class Class01 {
    public static void main(String[] args) {
        // Class 特点梳理
        // Class 不是牛new出来的 是系统创建的  通过 类加载器 ClassLoader类的loaderClass 创建出来的  类的价值只会有一次
        //

        Cat cat = new Cat();
        try {
            Class<?> aClass = Class.forName("fanshe.Cat");
            Object o = aClass.newInstance();

            // class 对象是放在堆中
            // 类的字节码二进制数据 是放在方法区的

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
