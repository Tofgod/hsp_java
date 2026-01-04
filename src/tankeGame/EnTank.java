package tankeGame;

public class EnTank extends Tank{

    public EnTank(int x, int y ) {
        super(x, y);
        this.setDirect(2);
        this.setType(1);
    }
}
