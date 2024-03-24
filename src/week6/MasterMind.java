package week6;

import week6.utils.ConsolUtils;
import week6.competition.MyAIPlayer;


import java.util.ArrayList;

public class MasterMind {

    Digits secretNumber;
    int digitCount;
    ArrayList<Player> players;
    int current;
    boolean isRoundOver;

    int[] scores;

    public MasterMind() {
        players = new ArrayList<>();
    }


    public void addPlayer(Player p)
    {
        players.add(p);
    }

    void play(int roundCount, int digitCount)
    {
        initGame(roundCount, digitCount);

        for (int r = 1; r <= roundCount; r++) {
            playOneRound(r);
        }

        printScores();
        congratulateWinner();


    }

    private void playOneRound(int r) {
        initRound(r);

        while (!isRoundOver)
        {
            playOneTurn();
        }

        endRound();
    }

    private void playOneTurn() {
        Player p = players.get(current);
        Digits guess = p.makeAGuess();

        if (!MasterMindUtils.isValid(guess,digitCount))
        {
            invalidGuess();
        }
        else
        {
            MMComparison comparison = MasterMindUtils.compare(guess,secretNumber);
            System.out.println(guess + " " + comparison);

            for (Player player:players)
                player.giveAnswer(guess,comparison);
            if (comparison.getPlus() == digitCount)
            {
                isRoundOver = true;
                return;
            }
        }

        current = (current+1 )% players.size();
    }

    private void invalidGuess() {
        System.out.println(ConsolUtils.colorize("INVALID GUESS!",ConsolUtils.ANSI_RED));
    }

    private void endRound() {
        Player winner = players.get(current);
        winner.winRound();
        scores[current]++;
        System.out.println(ConsolUtils.colorize("ROUND IS OVER!", ConsolUtils.ANSI_RED ));
    }

    private void initRound(int r) {
        secretNumber = MasterMindUtils.randomNumber(digitCount);
        isRoundOver = false;
        current = ((r-1)%players.size());
        System.out.println(ConsolUtils.colorize("Round-"+ r + " started.",ConsolUtils.ANSI_RED));

        for (Player p :players)
            p.initRound(r);

    }

    private void congratulateWinner() {

        int maxIndex=0;

        for (int i = 1; i < scores.length; i++) {
            if (scores[maxIndex]<scores[i])
                maxIndex =i;
        }
        Player winner = players.get(maxIndex);

        winner.congratulate();
    }

    private void printScores() {
        System.out.println(ConsolUtils.colorize("SCORES",ConsolUtils.ANSI_YELLOW));
        System.out.println(ConsolUtils.colorize("-------------------------",ConsolUtils.ANSI_YELLOW));
        for (int p = 0; p < players.size(); p++) {
            Player player = players.get(p);
            System.out.println(player + " : "+ scores[p]);
        }
    }

    private void initGame(int roundCount, int digitCount) {
        System.out.println(ConsolUtils.colorize(roundCount + " rounds of "+ digitCount + "-digits Mastermind started.",ConsolUtils.ANSI_RED));
        this.digitCount = digitCount;

        scores = new int[players.size()];
        for (Player p: players) {
            p.initGame(roundCount, digitCount);
        }

    }

    public static void main(String[] args) {
        MasterMind mm = new MasterMind();

        mm.addPlayer(new DummyPlayer("Dummy"));
        mm.addPlayer(new MyAIPlayer());

        mm.play(100,4);
    }

}
