package tankeGame;

import java.util.Vector;

public class MyTanK extends Tank{

    public MyTanK(int x, int y) {
        super(x, y);
    }


    public void shot(){

        Shot shot = null;

        if (getDirect() == 0){
            shot = new Shot(getX()+20  ,getY() ,getDirect()); // 简写 位置优化
        }
        if (getDirect() == 1){
            shot = new Shot(getX()+60  ,getY() + 20 ,getDirect()); // 简写 位置优化
        }
        if (getDirect() == 2){
            shot = new Shot(getX()+20  ,getY() + 60 ,getDirect()); // 简写 位置优化
        }
        if (getDirect() == 3){
            shot = new Shot(getX()  ,getY() + 20 ,getDirect()); // 简写 位置优化
        }

        Thread thread = new Thread(shot);
        thread.start();

        shots.add(shot);

    }

}
