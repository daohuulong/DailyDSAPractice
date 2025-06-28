package src.main.java.Processor.medium;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box3x3 = new int[9][9];
        char offset = '1';
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!".".equalsIgnoreCase(String.valueOf(board[i][j]))) {
                    int value = board[i][j] - offset;
                    var box = (i / 3) * 3 + (j / 3);
                    if (row[i][value] > 0
                            || col[j][value] > 0
                            || box3x3[box][value] > 0
                    )
                        return false;
                    row[i][value] ++;
                    col[j][value] ++;
                    box3x3[box][value]++;
                }
            }
        }
        return true;
    }

}
