package com.interface_;

public class Test03 {
    public static void main(String[] args) {

        Ig ig = new HG();

        Ih ih = new HG();

        AC.getInstance();

        HG hg = new HG();

    }
}

final class AC {

    private static AC a = null;

    private AC(){}

    public static AC getInstance(){
        if (a == null){
            a = new AC();
        }
        return a;
    }
}

//多态传递

interface Ih{

}

interface Ig extends Ih{
    int x = 1;
}

class II{
    public int x = 1;
}

class HG extends II implements Ig {
    void ad(){
        System.out.println(super.x); //会出现混淆
    }
}