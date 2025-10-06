package view;

import model.Board;
import model.Move;

import java.util.Scanner;

public class ConsoleView {

    public void mostrarTabuleiro(Board board) {
        board.exibir();  // Chama o método que exibe o tabuleiro
    }

    public Move pedirJogada() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        while (true) {
            System.out.print("Informe a linha (0-2): ");
            linha = scanner.nextInt();
            System.out.print("Informe a coluna (0-2): ");
            coluna = scanner.nextInt();

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
                break;
            } else {
                System.out.println("Coordenadas inválidas! Tente novamente.");
            }
        }

        return new Move(linha, coluna);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
