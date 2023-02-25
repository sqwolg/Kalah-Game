package Kalah;
public interface Board {
    Position getPosition(); //возвращает доску в теккущем состоянии
    int getNo(); // возвращает номер игрока, чей ход сейчас
    Result makeMove(Move move); //делает ход на доске
}
