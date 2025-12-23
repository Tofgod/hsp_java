package com.tankeProject;


import javax.swing.*;
import java.awt.*;

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
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭程序的按键
        //显示
        this.setVisible(true);
    }
}
//1.定义一个面板类 继承 JPanel
class MyPanel extends JPanel{

    //Graphics 画类 可以创建坐标宽高 图形上下文基类
    // 第一次显示屏幕的时候  paint  会被调用  窗口大小发生变化的时候 会被调用 repaint的时候方法会被调用
    @Override
    public void paint(Graphics g) {  // 绘图方法
        super.paint(g);
        System.out.println("方法被调用了");
        g.drawOval(0,0,100,100);   //绘画椭圆   x，y在左上角的位置 ；在x，y组成  width height 矩形  在内部绘画椭圆
        g.drawLine(20,50,100,50);  //坐标 画直线  x1 y1  x2 y2
        g.drawRect(30, 80 , 100 , 100); // 话矩形
        g.setColor(Color.red);
        g.fillOval(0,0,100,100); //填充椭圆
        g.setColor(Color.blue);
        g.fillRect(30, 80 , 100 , 100); // //填充矩形

        //画图片 获取图片资源  图片资源放在out的项目的根目录下路径下  固定写法
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/a.png"));
        g.drawImage(image , 10 ,10 , 200 , 100 ,this ); //this 是什么意思
        // this 作为 ImageObserver 参数，让当前组件能够监控图像的异步加载过程，并在图像数据可用时自动更新显示。这是 Java AWT/Swing 图像处理的重要机制。

        g.setFont(new Font("行书" , Font.BOLD , 50));
        g.drawString("吕",250,100);  //x , y 对应左下角
    }


}


