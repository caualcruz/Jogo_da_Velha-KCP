package controller;

import model.Board;
import model.Move;
import model.Player;
import view.ConsoleView;

public class Game {
    private Board board;
    private ConsoleView view;
    private Player p1, p2;

    public Game(ConsoleView view, Player p1, Player p2) {
        this.view = view;
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board();
    }

    public void iniciarPartida() {
        Player jogadorAtual = p1;
        while (true) {
            view.mostrarTabuleiro(board);
            view.exibirMensagem(jogadorAtual.getNome() + " (" + jogadorAtual.getSimbolo() + ") - Sua vez!");

            Move jogada = view.pedirJogada();
            if (board.marcar(jogada.getLinha(), jogada.getColuna(), jogadorAtual.getSimbolo())) {
                if (board.verificarVitoria(jogadorAtual.getSimbolo())) {
                    view.mostrarTabuleiro(board);
                    view.exibirMensagem(jogadorAtual.getNome() + " venceu!");
                    break;
                }
                if (board.estaCheio()) {
                    view.mostrarTabuleiro(board);
                    view.exibirMensagem("Empate!");
                    break;
                }

                jogadorAtual = (jogadorAtual == p1) ? p2 : p1;  // Alterna o jogador
            } else {
                view.exibirMensagem("Posição ocupada, tente novamente.");
            }
        }
    }
}