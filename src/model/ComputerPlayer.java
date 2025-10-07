package model;

import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String nome, char simbolo) {
        super(nome, simbolo);
    }

    // Simples: escolhe uma célula vazia aleatória
    public int[] escolherJogada(Board board) {
        List<int[]> vazias = board.getCelulasVazias();
        Random random = new Random();
        return vazias.get(random.nextInt(vazias.size()));
    }
}