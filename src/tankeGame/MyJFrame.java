package tankeGame;


import javax.swing.*;

public class MyJFrame extends JFrame {

    private MyPanel myPanel = null ;

    public MyJFrame(){
        //初始化面板
        myPanel = new MyPanel();
        //给窗口 JFrame 添加面板
        this.add(myPanel);
        this.addKeyListener(myPanel);
        //设置窗口大小
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭程序的按键
        //显示
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyJFrame();
    }

}
