package tankeGame;


import java.util.Random;

public class EnTank extends Tank implements Runnable{


    private Random random = new Random();
    // 冷却时间控制
    private long lastShotTime = 0;
    private int cooldown = 1500; // 基础冷却时间800ms
    // 随机冷却时间偏移
    private int cooldownVariance = 400; // ±400ms的随机偏移

    // 在某一个方向走过了多少步
    private int stepFD = 0 ;



    public EnTank(int x, int y ) {
        super(x, y);
        this.setDirect((int)(Math.random() * 4 ));
        this.setType(1);
        this.setSpeed(10);
    }

    public void shot(){

        // 检查冷却时间
        long currentTime = System.currentTimeMillis();
        long actualCooldown = cooldown + random.nextInt(cooldownVariance * 2) - cooldownVariance;

        if (currentTime - lastShotTime < actualCooldown) {
            return; // 还在冷却中，不发射
        }

        // 额外的随机发射概率（80%概率发射）
        if (random.nextInt(100) < 20) { // 20%概率即使冷却好了也不发射
            lastShotTime = currentTime; // 仍然记录发射时间，避免连续判断
            return;
        }

        // 更新最后发射时间
        lastShotTime = currentTime;

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

    @Override
    public void run() {
        while (isActive){
            move();
            shot();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void move(){

        //在某一个方向走多少步的阈值
        if ((getDirect()==0 && getY() < 40 )|| (getDirect()==1 && getX() > 740 ) || (getDirect()==3 && getY() > 740 ) || (getDirect()==4 && getX() < 40 )){
            stepFD = 0;
            setDirect((int)(Math.random() * 4 ));
        }
        if(stepFD > (int)(Math.random() * 6 ) + 4 ){
            stepFD = 0;
            setDirect((int)(Math.random() * 4 ));
        }else{
            switch (getDirect()){
                case 0 :
                    up();
                    break;
                case 1:
                    right();
                    break;
                case 2:
                    down();
                    break;
                case 3:
                    left();
                    break;
            }
            stepFD ++ ;
        }


    }

}
