package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private char[][] grid = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '_';
            }
        }
    }

    public boolean marcar(int linha, int coluna, char simbolo) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && grid[linha][coluna] == '_') {
            grid[linha][coluna] = simbolo;
            return true;
        }
        return false;
    }

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

    public boolean verificarVitoria(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == simbolo && grid[i][1] == simbolo && grid[i][2] == simbolo) return true;
            if (grid[0][i] == simbolo && grid[1][i] == simbolo && grid[2][i] == simbolo) return true;
        }
        return (grid[0][0] == simbolo && grid[1][1] == simbolo && grid[2][2] == simbolo)
                || (grid[0][2] == simbolo && grid[1][1] == simbolo && grid[2][0] == simbolo);
    }

    public void exibir() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
