package com.exception;

public class Test03 {
    public static void main(String[] args) {
        try {

        } catch (NullPointerException e ){ //子异常

        } catch (ArithmeticException e) {
//            throw new RuntimeException(e);
        } catch (Exception e) { //父亲异常
//            throw new RuntimeException(e);
        }finally {
            // 不管是否有异常 这个永远执行
        }


        try{

        }finally {
            // 程序会崩但是会执行finally
        }

//        throw new RuntimeException();


        // catch  finally 都有return 的时候  先执行catch 的内容 但并不会返回  执行finally 里面的return  再返回
        // 当 catch 有return finally 没有return的时候 在执行到catch return语句的时候不会立刻返回 会先执行finally 然后再返回

        try{
            int a = 10/0;
        }catch (Exception e){

        }finally {

        }

    }
}


