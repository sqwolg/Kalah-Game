package Kalah;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private int no = 0;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    int makeMove(Player player, int no) {
        final Result result = board.makeMove(player.move(board.getPosition(), no));
        return switch (result) {
            case WIN -> no + 1;
            case LOSE -> 2 - no;
            case DRAW -> 0;
            default -> -1;
        };
    }

    public int play() {
        while(true) {
            final int result;
            if(no == 0) {
                result = makeMove(player1, 0);
            } else {
                result = makeMove(player2, 1);
            }
            no = board.getNo();
            if (result != -1){
                return result;
            }
        }
    }
}
