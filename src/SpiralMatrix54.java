import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        
        int i = 0, j = 0;
        boolean[][] visited = new boolean[m][n];
        while (i < m && j < n && !visited[i][j]) {
            // first
            while (j < n && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                j++;
            }
            j--; // above while loop incremented it so making one step back
            i++;
            //second
            while (i < m && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                i++;
            }
            i--;
            j--;
            // third
            while (j >= 0 && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                j--;
            }
            j++;
            i--;
            // fourth
            while (i >= 0 && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                i--;
            }
            i++;
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        
    }
}
