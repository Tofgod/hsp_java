package tankeGame;


import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyJFrame extends JFrame {

    private MyPanel myPanel = null ;

    public MyJFrame(){
        //初始化面板
        myPanel = new MyPanel();
        Thread thread = new Thread(myPanel);
        thread.start();
        //给窗口 JFrame 添加面板
        this.add(myPanel);
        this.addKeyListener(myPanel);
        //设置窗口大小
        this.setSize(1500,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭程序的按键
        //显示
        this.setVisible(true);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听到关闭");
                Recorder.keepR();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new MyJFrame();
    }

}
