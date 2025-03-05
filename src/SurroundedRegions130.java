import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions130 {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {{0,-1}, {0,1}, {-1, 0}, {1,0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && i != m-1 && j != 0 && j != n-1 && board[i][j] == 'O') {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    List<int[]> regions = new ArrayList<>();
                    Queue<int[]> que = new LinkedList<>();
                    que.add(new int[]{i,j});

                    while (!que.isEmpty()) {
                        int[] curr = que.poll();
                        regions.add(curr);

                        for (int[] direction : directions) {
                            int x = curr[0] + direction[0];
                            int y = curr[1] + direction[1];

                            if (x < 0 || x > m-1 || y < 0 || y > n-1 || visited[x][y] || board[x][y] == 'X') continue;

                            if (x == 0 || x == m-1 || y == 0 || y == n-1) {
                                que.clear();
                                regions.clear();
                                break;
                            }

                            visited[x][y] = true;
                            que.add(new int[]{x,y});
                        }
                    }

                    int k = 0;
                    while (k < regions.size()) {
                        int[] currRegion = regions.get(k++);
                        board[currRegion[0]][currRegion[1]] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
