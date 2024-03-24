package week6;

public class DummyPlayer extends AIPlayer{
    public DummyPlayer(String name) {
        super(name);
    }

    @Override
    protected void _initGame(int roundCount) {
        System.out.println("HAHAHAHA I WILL BEAT ALL OF YOU!");
    }

    @Override
    protected void _congratulate() {
        System.out.println("");
    }

    @Override
    protected void _initRound(int r) {
        System.out.println("O SENE BU SENE");
    }

    @Override
    protected void _winRound() {
        System.out.println();
    }

    @Override
    protected Digits _makeAGuess() {
        return MasterMindUtils.randomNumber(digitCount);
    }

    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {
        System.out.println("HMM!!");
    }
}
