package week6.competition;

import week6.AIPlayer;
import week6.Digits;
import week6.MMComparison;
import week6.MasterMindUtils;

import java.sql.Array;
import java.util.Random;

public class MyAIPlayer extends AIPlayer {
    public int[] numbers;
    public boolean allSymbolsAreOk = false;

    public MyAIPlayer() {
        super("Your Name");
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

        if (allSymbolsAreOk){
            Random random = new Random();
            for (int i = numbers.length - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                int temp = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = temp;
            }

            int arrayToInt = 0;

            for (int digit : numbers) {
                arrayToInt = arrayToInt * 10 + digit;
            }

            return new Digits(arrayToInt);
        }

        return MasterMindUtils.randomNumber(digitCount);
    }

    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {
        int plusValue = comparison.getPlus();
        int minusValue = comparison.getMinus();

        //System.out.println("Plus value: " + plusValue);
        //System.out.println("Minus value: " + minusValue);

        if (minusValue == 4){
            allSymbolsAreOk = true;
            System.out.println("AHA! --> " + guess);
            numbers = guess.getDigits();
        }
    }
}
