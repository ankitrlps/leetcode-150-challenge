
public class WordSearch79 {

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, i, j, word, 0, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || board[i][j] != word.charAt(index))
            return false;

        visited[i][j] = true;

        if (backtrack(board, i, j + 1, word, index + 1, visited) ||
                backtrack(board, i, j - 1, word, index + 1, visited) ||
                backtrack(board, i + 1, j, word, index + 1, visited) ||
                backtrack(board, i - 1, j, word, index + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'a','b'},{'c','d'}}, "acdb"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
        System.out.println(exist(new char[][]{{'a','b'},{'c','d'}}, "abcd"));
        System.out.println(exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB"));
    }
}
