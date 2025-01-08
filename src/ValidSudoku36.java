import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku36 {

    // using sqaureKey as integer and creating new hashset for each row and col
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            squares.put(i, new HashSet<>());
        }
 
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                int squareKey = (r/3) * 3 + (c/3);

                if (rows.get(r).contains(board[r][c])
                || cols.get(c).contains(board[r][c])
                || squares.get(squareKey).contains(board[r][c])) return false;

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }

        return true;
    }

    // using sqaureKey as string
    public boolean isValidSudoku1(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r/3) + "," + (c/3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
                || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
                || squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) return false;

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }

        return true;
    }
    

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> set1 = new HashMap<>();
        set1.computeIfAbsent(2, j -> new HashSet<>());
    }
}
