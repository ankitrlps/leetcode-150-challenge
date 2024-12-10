import java.util.Arrays;

public class GameOfLife289 {

    int[][] directions = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } }; // 8 directions

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m][n]; 
        
        // creating a copy 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }

        // loop through each copy array element
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                traverse(i, j, m, n, copy, board);
            }
        }
    }

    // loops through all possible 8 directions for each live or died element in copy array
    // and count the neighbor lives
    // this calculation for each element in copy array is then used to update board array 
    // based on 4 conditions mentioned in the question
    void traverse(int i, int j, int m, int n, int[][] copy, int[][] board) { 
        boolean live = copy[i][j] == 1;
        int neighborLives = 0;

        for (int[] direct : directions) {
            int ii = i + direct[0];
            int jj = j + direct[1];

            if (ii < 0 || ii >= m || jj < 0 || jj >= n) {
                continue;
            }

            // count the neighborLives
            if (copy[ii][jj] == 1) {
                neighborLives++;
            }
        }
        
        if (live) {
            if (neighborLives < 2) { // under-population
                board[i][j] = 0;
            } else if (neighborLives > 3) { // over-population
                board[i][j] = 0;
            } else { // lives for next generation
                board[i][j] = 1; 
            }
        } else {
            if (neighborLives == 3) { // reproduction
                board[i][j] = 1;
            }
        }
    }
    
    public static void main(String[] args) {
        GameOfLife289 game = new GameOfLife289();
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        game.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
