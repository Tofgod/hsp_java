package tankeGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class MyPanel extends Panel implements KeyListener ,Runnable {

    MyTanK myTanK;

    Vector<EnTank> enTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();

    //存在懒加载的问题
//    Image image1;
//    Image image2;
//    Image image3;

    BufferedImage image1;
    BufferedImage image2;
    BufferedImage image3;


    int enTankSize = 3;



    public MyPanel()  {
        myTanK = new MyTanK(0,0);
        for (int i = 0; i < enTankSize; i++) {

            EnTank enTank = new EnTank((int)(Math.random() * 500 ),(int)(Math.random() * 500 ));
            Thread thread = new Thread(enTank);
            thread.start();
            enTanks.add(enTank);
        }

//        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/b1.png"));
//        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/b2.png"));
//        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/b3.png"));

        try {
             image1 = ImageIO.read(Panel.class.getResource("/b1.png"));
             image2 = ImageIO.read(Panel.class.getResource("/b2.png"));
             image3 = ImageIO.read(Panel.class.getResource("/b3.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
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


        if(myTanK.isActive){
            drawTank(myTanK.getX(), myTanK.getY(), g , myTanK.getDirect() , myTanK.getType());
        }
        // 子弹
        tankShot(myTanK,g);

        for (int i = 0; i < enTanks.size(); i++) {
            EnTank enTank = enTanks.get(i);
            hitTank(myTanK,enTank);
            hitTank(enTank,myTanK);
            if(enTank.isActive){
                drawTank(enTank.getX(),enTank.getY(),g,enTank.getDirect(), enTank.getType());
            }
            tankShot(enTank,g);
        }

        Iterator<Bomb> iterator = bombs.iterator();
        while (iterator.hasNext()) {
            Bomb bomb =  iterator.next();
            System.out.println(bomb.live);
            if (bomb.live > 6) {
                g.drawImage(image1 , bomb.x,bomb.y ,60 ,60 ,this  );
            }else if (bomb.live > 3){
                g.drawImage(image2 , bomb.x,bomb.y ,60 ,60 ,this  );
            }else  if(bomb.live > 0 ){
                g.drawImage(image3 , bomb.x,bomb.y ,60 ,60 ,this  );
            }
            bomb.delLive();
            if (!bomb.isActive){
                iterator.remove();
            }
        }

    }


    public void tankShot(Tank tank , Graphics g){
        for (int j = 0; j < tank.shots.size(); j++) {
            Shot shot = tank.shots.get(j);
            if (shot.isActive){
                g.fillOval(shot.x ,shot.y ,10 ,10 );
            }
        }
    }

    public void hitTank( Tank myTanK , Tank enTank){
        //判断子弹 跟 坦克 是否重叠 即被打中
        Iterator<Shot> iterator = myTanK.shots.iterator();
        while (iterator.hasNext()) {
            Shot shot =  iterator.next();
            // shot 的位置 跟 enTank 的位置进行比较
            if (shot.isActive && enTank.isActive && ((enTank.getX() < shot.x)  && ( enTank.getX() + 60 > shot.x)) &&
                    ((enTank.getY() < shot.y ) && (enTank.getY() + 60 > shot.y))){
                enTank.isActive = false;
                shot.isActive = false;
                System.out.println("坦克被击中");
                bombs.add(new Bomb(enTank.getX(),enTank.getY()));
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
