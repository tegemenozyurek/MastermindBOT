package week6;

public class MMComparison {
    private int plus;
    private int minus;

    public MMComparison(int plus, int minus) {
        this.plus = plus;
        this.minus = minus;
    }

    public int getPlus() {
        return plus;
    }

    public int getMinus() {
        return minus;
    }

    @Override
    public String toString() {
        return "+"+ plus + "-"+ minus;
    }
}
