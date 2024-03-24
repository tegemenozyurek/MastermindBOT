package week6;

import week6.utils.ConsolUtils;

public abstract class Player {
    private String  name;
    protected int digitCount;

    public Player(String name) {
        this.name = name;
    }

    public void initGame(int roundCount, int digitCount) {
        this.digitCount = digitCount;

        _initGame(roundCount);
    }

    protected abstract void _initGame(int roundCount);

    @Override
    public String toString() {
        return "["+name+"]";
    }

    public void congratulate() {
        _congratulate();
    }

    protected abstract void _congratulate();

    public void initRound(int r) {
        _initRound(r);
    }

    protected abstract void _initRound(int r);

    public void winRound() {
        _winRound();
    }

    protected abstract void _winRound();

    public Digits makeAGuess() {
        System.out.println(ConsolUtils.colorize(toString()+ " >> Enter a valid number :",ConsolUtils.ANSI_BLUE));
        return _makeAGuess();


    }

    protected abstract Digits _makeAGuess();

    public void giveAnswer(Digits guess, MMComparison comparison) {
        _giveAnswer(guess,comparison);
    }

    protected abstract void _giveAnswer(Digits guess, MMComparison comparison);
}
