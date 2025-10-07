package view;

import model.Board;

public class ConsoleView {

    public void displayBoard(Board board) {
        System.out.println();
        board.exibir(); // chama o método exibir do Board
        System.out.println();
    }
}
