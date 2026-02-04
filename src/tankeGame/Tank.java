package tankeGame;

import java.util.Vector;

public class Tank {
    private int X;
    private int Y;
    private int speed = 5;
    private int direct;
    private int type;
    private int range_w;
    private int range_h;


    // 子弹
    Vector<Shot> shots = new Vector<>();

    public void up(){
        direct = 0;
        if (Y <= speed) return;
        Y -= speed;
    }
    public void down(){
        direct = 2;
        Y += speed;
    }
    public void right(){
        direct = 1;
        X += speed;
    }
    public void left(){
        direct = 3;
        if (X <= speed) return;
        X -= speed;
    }

    public Tank(int x, int y) {
        X = x;
        Y = y;
    }

    public void shot(){

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}


