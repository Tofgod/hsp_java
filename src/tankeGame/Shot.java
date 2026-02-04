package tankeGame;

public class Shot implements Runnable{

    int x ;
    int y;
    private int speed = 2;
    private int direct; // 0 1 2 3
    boolean isActive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    // 不停改变坐标
    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (direct){
                case 0 :
                    this.y -= speed;
                    break;
                case 1 :
                    this.x += speed;
                    break;
                case 2 :
                    this.y += speed;
                    break;
                case 3 :
                    this.x -= speed;
                    break;
            }

            System.out.println("方向：" + direct);
            System.out.println("子弹坐标:" + x );

            if (!(x >= 0 && y >=0 && x <= 800 && y<=800)){
                isActive = false;
                break;
            }
        }
    }

}
