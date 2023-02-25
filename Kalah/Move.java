package Kalah;

public final class Move {

    private final int no;
    private final char num;

    public Move(int no, char num) {
        this.no = no;
        this.num = num;
    }

    public int getNum() {
        return num - 97;
    }
    public int getNo() {
        return no;
    }


    @Override
    public String toString() {
        return "Игрок под номером " + (no + 1) + ", сделал ход из клетки " + num;
    }
}

