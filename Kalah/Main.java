package Kalah;

public class Main {
    public static void main(String[] args) {
        final Game game = new Game(new KalahBoard(), new HumanPlayer(), new HumanPlayer());
        System.out.println("Game result: " + game.play());
    }
}
