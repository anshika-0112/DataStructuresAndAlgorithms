package LeetCode.April;

public class April_3_WordSearch {
    int[] steps_x = new int[]{0, 0, 1, -1};
    int[] steps_y = new int[]{1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (helper(i, j, n, m, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(int i, int j, int n, int m, char[][] board, String word, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != word.charAt(k)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        for (int l = 0; l < 4; l++) {
            if (helper(i + steps_x[l], j + steps_y[l], n, m, board, word, k + 1)) {
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}
