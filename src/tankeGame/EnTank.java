package tankeGame;

import java.util.Random;

public class EnTank extends Tank implements Runnable{


    private Random random = new Random();
    // 冷却时间控制
    private long lastShotTime = 0;
    private int cooldown = 1500; // 基础冷却时间800ms
    // 随机冷却时间偏移
    private int cooldownVariance = 400; // ±400ms的随机偏移

    public EnTank(int x, int y ) {
        super(x, y);
        this.setDirect(2);
        this.setType(1);
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
        move();
    }


    public void move(){

    }

}
