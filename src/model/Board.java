package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final char[][] grid = new char[3][3];

    // Construtor: inicializa o tabuleiro com '_'
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '_';
            }
        }
    }

    // Marca uma posição no tabuleiro com o símbolo do jogador
    public boolean marcar(int linha, int coluna, char simbolo) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && grid[linha][coluna] == '_') {
            grid[linha][coluna] = simbolo;
            return true;
        }
        return false;
    }

    // Retorna uma lista com todas as posições vazias
    public List<int[]> getCelulasVazias() {
        List<int[]> lista = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '_') {
                    lista.add(new int[]{i, j});
                }
            }
        }
        return lista;
    }

    // Verifica se o tabuleiro está cheio
    public boolean estaCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    // Verifica se o jogador venceu
    public boolean verificarVitoria(char simbolo) {
        // Linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == simbolo && grid[i][1] == simbolo && grid[i][2] == simbolo) return true;
            if (grid[0][i] == simbolo && grid[1][i] == simbolo && grid[2][i] == simbolo) return true;
        }
        // Diagonais
        return (grid[0][0] == simbolo && grid[1][1] == simbolo && grid[2][2] == simbolo)
                || (grid[0][2] == simbolo && grid[1][1] == simbolo && grid[2][0] == simbolo);
    }

    // Exibe o tabuleiro no console
    public void exibir() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
