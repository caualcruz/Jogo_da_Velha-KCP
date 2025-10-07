package view;

import model.Board;
import model.Move;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    // Exibe o tabuleiro
    public void mostrarTabuleiro(Board board) {
        board.exibir();
    }

    // Mostra uma mensagem no console
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    // Solicita uma jogada ao jogador
    public Move pedirJogada() {
        System.out.print("Digite a linha (0-2): ");
        int linha = scanner.nextInt();
        System.out.print("Digite a coluna (0-2): ");
        int coluna = scanner.nextInt();
        return new Move(linha, coluna);
    }

    public void displayBoard(Board board) {
    }
}
