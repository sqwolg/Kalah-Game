package Kalah;

import java.util.Arrays;

public class KalahBoard implements Board, Position{
    private int[][] board = new int[2][6];
    private int[] result = new int[]{0, 0};
    private int no;

    public KalahBoard() {
        for (int[] row : board) {
            Arrays.fill(row, 6);
        }
        no = 0;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public int getNo() {
        return no;
    }

    @Override
    public Result makeMove(Move move) {
        int num = move.getNum();
        no = move.getNo();

        if(!isValid(move)) {
            return Result.LOSE;
        }

        final int in = board[no][num];
        board[no][num] = 0;
        for(int i = 1; i <= in; i++) {
            if(num + i >= 6) {
                no = 1 - no;
                num -= 6;
                if(move.getNo() == no) {
                    result[move.getNo()]++;
                    if(i++ <= in) {
                        break;
                    }
                }
            }
            board[no][num + i] += 1;
        }


        int count = 0;
        for (int r = 0; r < 6; r++) {
            if(board[move.getNo()][r] != 0) {
                count++;
                break;
            }
        }
        if(count == 0 && result[move.getNo()] > result[1 - move.getNo()]) {
            return Result.WIN;
        } else if (count == 0 && result[move.getNo()] < result[1 - move.getNo()]) {
            return Result.LOSE;
        } else if (count == 0 && result[move.getNo()] == result[1 - move.getNo()]) {
            return Result.DRAW;
        } else {
            return Result.UNKNOWN;
        }
    }

    public boolean isValid(final Move move) {
        int num = move.getNum();
        return num >= 0 && num < 6 && board[move.getNo()][num] != 0;
    }

    @Override //надо сделать
    public int getValue(int r, int c) {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("    K  f e d c b a");
        sb.append("\n");
        sb.append("P2");
        sb.append("  ");
        sb.append(result[1]);
        sb.append("  ");
        for (int c = 5; c >= 0; c--) {
            sb.append(board[1][c]);
            sb.append("|");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
        sb.append("P1");
        sb.append("     ");
        for (int c = 0; c < 6; c++) {
            sb.append(board[0][c]);
            sb.append("|");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("  ");
        sb.append(result[0]);
        sb.append("\n");
        sb.append("       a b c d e f  K");

        return sb.toString();
    }
}
