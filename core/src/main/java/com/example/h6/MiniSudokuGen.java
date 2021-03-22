package com.example.h6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiniSudokuGen {

    private void printSudoku(int[][] sudoku) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : sudoku) {
            sb.append("|");
            for (int val : row) {
                sb.append(val).append("|");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private int[][] generateSudoku() {
        ArrayList<Integer> values = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(values);
        int[][] sudoku = new int[3][3];
        for (int i = 0; i < 9; i++) {
            sudoku[i/3][i%3] = values.get(i);
        }
        return sudoku;
    }

    public static void main(String[] args) {
        MiniSudokuGen miniSudokuGen = new MiniSudokuGen();
        var sudoku = miniSudokuGen.generateSudoku();
        miniSudokuGen.printSudoku(sudoku);
    }
}
