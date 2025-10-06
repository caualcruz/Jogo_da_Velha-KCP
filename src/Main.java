

import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Jogo da Velha ===");
        System.out.println("1 - Jogar contra outro humano");
        System.out.println("2 - Jogar contra o computador");
        System.out.print("Escolha: ");
        int modo = sc.nextInt();
        sc.nextLine();

        Board board = new Board();
        Player p1 = new Player("Jogador 1", 'X');
        Player p2 = (modo == 1)
                ? new Player("Jogador 2", 'O')
                : new ComputerPlayer("Computador", 'O');

        Player atual = p1;

        while (true) {
            board.exibir();
            System.out.println(atual.getNome() + " (" + atual.getSimbolo() + ") é sua vez.");

            int linha, coluna;
            if (modo == 2 && atual instanceof ComputerPlayer) {
                int[] jogada = ((ComputerPlayer) atual).escolherJogada(board);
                linha = jogada[0];
                coluna = jogada[1];
                System.out.println("Computador escolheu: " + (linha + 1) + "," + (coluna + 1));
            } else {
                System.out.print("Informe linha (1-3): ");
                linha = sc.nextInt() - 1;
                System.out.print("Informe coluna (1-3): ");
                coluna = sc.nextInt() - 1;
            }

            if (!board.marcar(linha, coluna, atual.getSimbolo())) {
                System.out.println("Posição inválida. Tente novamente.");
                continue;
            }

            if (board.verificarVitoria(atual.getSimbolo())) {
                board.exibir();
                System.out.println(atual.getNome() + " venceu!");
                break;
            }

            if (board.estaCheio()) {
                board.exibir();
                System.out.println("Empate!");
                break;
            }

            atual = (atual == p1) ? p2 : p1;
        }

        sc.close();
    }
}
