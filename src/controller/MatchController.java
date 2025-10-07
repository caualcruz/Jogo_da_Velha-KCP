package controller;

import model.*;
import view.ConsoleView;

import java.util.Scanner;

public class MatchController {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final ConsoleView view;
    private final Scanner scanner;

    public MatchController(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.view = new ConsoleView();
        this.scanner = new Scanner(System.in);
    }

    public void startMatch() {
        Player currentPlayer = player1;
        boolean gameOver = false;

        while (!gameOver) {
            view.displayBoard(board);
            System.out.println("Vez de " + currentPlayer.getNome() + " (" + currentPlayer.getSimbolo() + ")");

            int[] move = getPlayerMove(currentPlayer);
            if (!board.marcar(move[0], move[1], currentPlayer.getSimbolo())) {
                System.out.println("Posição inválida! Tente novamente.");
                continue;
            }

            if (board.verificarVitoria(currentPlayer.getSimbolo())) {
                view.displayBoard(board);
                System.out.println("🎉 " + currentPlayer.getNome() + " venceu!");
                gameOver = true;
            } else if (board.estaCheio()) {
                view.displayBoard(board);
                System.out.println("😐 Empate!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }

    private int[] getPlayerMove(Player player) {
        if (player instanceof ComputerPlayer) {
            return getComputerMove();
        }

        System.out.print("Digite a posição (1-9): ");
        int pos = scanner.nextInt() - 1;
        return new int[]{pos / 3, pos % 3};
    }

    private int[] getComputerMove() {
        // Movimento simples (escolhe posição aleatória válida)
        while (true) {
            int pos = (int) (Math.random() * 9);
            int row = pos / 3;
            int col = pos % 3;
            if (!isCellOccupied(row, col)) {
                System.out.println("Computador escolheu posição " + (pos + 1));
                return new int[]{row, col};
            }
        }
    }

    private boolean isCellOccupied(int row, int col) {
        // Usa reflexão do tabuleiro pra verificar se célula está ocupada
        try {
            var field = Board.class.getDeclaredField("grid");
            field.setAccessible(true);
            char[][] grid = (char[][]) field.get(board);
            return grid[row][col] != '_';
        } catch (Exception e) {
            return true;
        }
    }
}
