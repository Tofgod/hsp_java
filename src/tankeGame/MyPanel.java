package tankeGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends Panel implements KeyListener ,Runnable {

    MyTanK myTanK;

    Vector<EnTank> enTanks = new Vector<>();

    int enTankSize = 3;

    public MyPanel(){
        myTanK = new MyTanK(0,0);
        for (int i = 0; i < enTankSize; i++) {
            EnTank enTank = new EnTank(100 * (i + 1), 0);
            Thread thread = new Thread(enTank);
            thread.start();
            enTanks.add(enTank);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            myTanK.down();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            myTanK.up();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            myTanK.left();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            myTanK.right();
        }
        if(e.getKeyCode() == KeyEvent.VK_J){
            myTanK.shot();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTank(myTanK.getX(), myTanK.getY(), g , myTanK.getDirect() , myTanK.getType());


        // 子弹
        for (int i = 0; i < myTanK.shots.size(); i++) {
            Shot shot = myTanK.shots.get(i);
            if (shot.isActive){
                g.fillOval(shot.x ,shot.y ,10 ,10 );
            }
        }


        for (int i = 0; i < enTanks.size(); i++) {
            EnTank enTank = enTanks.get(i);
            drawTank(enTank.getX(),enTank.getY(),g,enTank.getDirect(), enTank.getType());
            enTankShot(enTank,g);
        }
    }


    public void enTankShot(Tank tank , Graphics g){
        // 完善敌方坦克射击算法
        tank.shot();
        for (int j = 0; j < tank.shots.size(); j++) {
            Shot shot = tank.shots.get(j);
            if (shot.isActive){
                g.fillOval(shot.x ,shot.y ,10 ,10 );
            }
        }

    }

    /**
     * @param x x坐标
     * @param y y坐标
     * @param g 画笔
     * @param direct 方向
     * @param type 坦克类型
     * */

    public void drawTank(int x , int y ,Graphics g ,int direct,int type){

        switch (type){
            case 0 :
                g.setColor(Color.blue);
                break;
            case 1 :
                g.setColor(Color.red);
                break;
        }

        switch (direct){
            case 0 : //向上
                g.drawRect(x,y,10,60);
                g.drawRect(x+10,y+10,30,40);
                g.drawRect(x+40,y,10,60);
                g.fillOval(x+15,y+20,20,20); //填充椭圆
                g.drawLine(x+25,y+30,x+25,y);
                break;
            case 1 :
                g.drawRect(x,y,60,10);
                g.drawRect(x+10,y+10,40,30);
                g.drawRect(x,y+40,60,10);
                g.fillOval(x+20,y+15,20,20); //填充椭圆
                g.drawLine(x+60,y+25,x+30,y+25);
                break;
            case 2 :
                g.drawRect(x,y,10,60);
                g.drawRect(x+10,y+10,30,40);
                g.drawRect(x+40,y,10,60);
                g.fillOval(x+15,y+20,20,20); //填充椭圆
                g.drawLine(x+25,y+60,x+25,y+30);
                break;
            case 3 :
                g.drawRect(x,y,60,10);
                g.drawRect(x+10,y+10,40,30);
                g.drawRect(x,y+40,60,10);
                g.fillOval(x+20,y+15,20,20); //填充椭圆
                g.drawLine(x+30,y+25,x,y+25);
                break;
        }

    }
}
