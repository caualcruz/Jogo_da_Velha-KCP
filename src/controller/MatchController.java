package controller;

import model.Player;
import model.Board;
import view.ConsoleView;

import java.util.Scanner;

public class MatchController {

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        ConsoleView view = new ConsoleView();

        while (true) {
            System.out.println("1) Humano vs Humano");
            System.out.println("2) Humano vs Computador");
            System.out.println("3) Computador vs Computador");
            System.out.println("0) Sair");

            int escolha = scanner.nextInt();

            if (escolha == 0) {
                break;
            }

            Player p1 = null;
            Player p2 = null;

            if (escolha == 1) {
                p1 = new Player("Jogador 1", 'X');
                p2 = new Player("Jogador 2", 'O');
            } else if (escolha == 2) {
                p1 = new Player("Jogador", 'X');
                p2 = new Player("Computador", 'O');
            } else if (escolha == 3) {
                p1 = new Player("Computador 1", 'X');
                p2 = new Player("Computador 2", 'O');
            }

            Game game = new Game(view, p1, p2);
            game.iniciarPartida();
        }
    }
}
