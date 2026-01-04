package com.tankeProject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//绘图  extends JFrame 窗口
public class Draw extends JFrame{


    private MyPanel myPanel = null ;

    public static void main(String[] args) {
        new Draw();//
        System.out.println("quit");
    }


    public Draw(){
        //初始化面板
        myPanel = new MyPanel();
        //给窗口 JFrame 添加面板
        this.add(myPanel);
        //设置窗口大小
        this.setSize(800,800);
        this.addKeyListener(myPanel );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭程序的按键
        //显示
        this.setVisible(true);
    }
}
//1.定义一个面板类 继承 JPanel
class MyPanel extends JPanel implements KeyListener {

    int x ;
    int y ;
    int speed = 10;
    Graphics g ;

    @Override
    //有字符输出
    public void keyTyped(KeyEvent e) {

    }


    //当摸一个键位被按下
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            y += speed ;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            if (y == 0){
                return;
            }
            y -=speed ;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if (x == 0){
                return;
            }
            x -=speed ;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            x +=speed ;
        }
        this.repaint();

    }

    //当某一个键位释放
    @Override
    public void keyReleased(KeyEvent e) {

    }

    //Graphics 画类 可以创建坐标宽高 图形上下文基类
    // 第一次显示屏幕的时候  paint  会被调用  窗口大小发生变化的时候 会被调用 repaint的时候方法会被调用
    @Override
    public void paint(Graphics g) {  // 绘图方法
        super.paint(g);
        System.out.println("方法被调用了");
//        g.drawOval(0,0,100,100);   //绘画椭圆   x，y在左上角的位置 ；在x，y组成  width height 矩形  在内部绘画椭圆
//        g.drawLine(20,50,100,50);  //坐标 画直线  x1 y1  x2 y2
//        g.drawRect(30, 80 , 100 , 100); // 话矩形
//        g.setColor(Color.red);
//        g.fillOval(0,0,100,100); //填充椭圆
//        g.setColor(Color.blue);
//        g.fillRect(30, 80 , 100 , 100); // //填充矩形
//
//        //画图片 获取图片资源  图片资源放在out的项目的根目录下路径下  固定写法
////        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/a.png"));
////        g.drawImage(image , 10 ,10 , 200 , 100 ,this ); //this 是什么意思
//        // this 作为 ImageObserver 参数，让当前组件能够监控图像的异步加载过程，并在图像数据可用时自动更新显示。这是 Java AWT/Swing 图像处理的重要机制。
//
//        g.setFont(new Font("行书" , Font.BOLD , 50));
//        g.drawString("吕",250,100);  //x , y 对应左下角


        g.setColor(Color.blue);
        g.drawRect(x,y,10,60);
        g.drawRect(x+10,y+10,30,40);
        g.drawRect(x+40,y,10,60);
        g.fillOval(x+15,y+20,20,20); //填充椭圆
        g.drawLine(x+25,y+30,x+25,y);
    }


}


