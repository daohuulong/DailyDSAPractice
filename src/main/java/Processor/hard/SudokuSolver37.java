package src.main.java.Processor.hard;

import java.util.*;

public class SudokuSolver37 {
    static class Solution {
        char[][] board;

        public void solveSudoku(char[][] board) {
            this.board = board;
            dfs(0);
        }

        private boolean dfs(int idx) {
            if (idx == 81)
                return true;
            if (checkEnd())
                return true;
            int r = toRow(idx);
            int c = toCol(idx);
            if (board[r][c] != '.')
                return dfs(idx + 1);
            for (var num = '1'; num <= '9'; num++) {
                if (!checkValid(r, c, num))
                    continue;
                board[r][c] = num;
                if (dfs(idx + 1))
                    return true;
                board[r][c] = '.';
            }
            return false;
        }

        private boolean checkValid(int r, int c, char num) {
            for (int i = 0; i < 9; i++) {
                if (board[r][i] == num)
                    return false;
                if (board[i][c] == num)
                    return false;
            }
            int x = (r / 3) * 3;
            int y = (c / 3) * 3;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (board[x + i][y + j] == num)
                        return false;
            return true;
        }

        private boolean checkEnd() {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    if (board[i][j] == '.')
                        return false;
            return true;
        }

        private int toRow(int cell) {
            return cell / 9;
        }

        private int toCol(int cell) {
            return cell % 9;
        }
    }

    public static void main(String[] args) {
        String[][] testCase = new String[][]
                {{".", ".", ".", ".", ".", ".", ".", ".", "."}, {".", "9", ".", ".", "1", ".", ".", "3", "."}, {".", ".", "6", ".", "2", ".", "7", ".", "."}, {".", ".", ".", "3", ".", "4", ".", ".", "."}, {"2", "1", ".", ".", ".", ".", ".", "9", "8"}, {".", ".", ".", ".", ".", ".", ".", ".", "."}, {".", ".", "2", "5", ".", "6", "4", ".", "."}
                        , {".", "8", ".", ".", ".", ".", ".", "1", "."}, {".", ".", ".", ".", ".", ".", ".", ".", "."}};
        char[][] charTestcase = new char[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                charTestcase[i][j] = testCase[i][j].charAt(0);
            }
        Solution sudokuSolver37 = new Solution();
        sudokuSolver37.solveSudoku(charTestcase);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(charTestcase[i][j] + ",");
            }
            System.out.println();
        }
    }
}
