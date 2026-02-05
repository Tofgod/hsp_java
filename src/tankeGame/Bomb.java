package tankeGame;

public class Bomb {

    public int x;
    public int y;
    public int live = 9;
    public boolean isActive = true;


    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void delLive(){
        if (live > 0){
            live--;
        }else{
            isActive = false;
        }
    }
}
