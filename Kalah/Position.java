package Kalah;

public interface Position {
    boolean isValid(Move move);

    int getValue(int r, int c);
}
