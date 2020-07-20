package inf5153.Rules.Dice;

/**
 * Created by wflag on 2020-06-08.
 */
public class PowerFace extends DieFace {
    private int power;

    public PowerFace(int p) {
        power = p;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getPrice() {
        return power;
    }

    @Override
    public String toString() {
        return String.format("Face: %d", power);
    }
}
