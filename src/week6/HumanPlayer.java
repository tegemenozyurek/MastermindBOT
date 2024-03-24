package week6;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    protected void _initGame(int roundCount) {

    }

    @Override
    protected void _congratulate() {

    }

    @Override
    protected void _initRound(int r) {

    }

    @Override
    protected void _winRound() {

    }

    @Override
    protected Digits _makeAGuess() {
        Scanner scanner = new Scanner(System.in);

        int n= scanner.nextInt();
        return new Digits(n);
    }

    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {

    }
}
