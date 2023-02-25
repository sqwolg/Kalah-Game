package Kalah;

import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final PrintStream out;
    private final Scanner in;

    public HumanPlayer(final PrintStream out, final Scanner in) {
        this.out = out;
        this.in = in;
    }

    public HumanPlayer() {
        this(System.out, new Scanner(System.in));
    }

    @Override
    public Move move(final Position position, int no) {
        while (true) {
            out.println("Position");
            out.println(position);
            out.println(no + "'s move");
            out.println("Enter row");
            final Move move = new Move(no, in.next().charAt(0));
            if (position.isValid(move)) {
                return move;
            }
            final int row = move.getNum();
            out.println("Move " + move + " is invalid");
        }
    }
}
