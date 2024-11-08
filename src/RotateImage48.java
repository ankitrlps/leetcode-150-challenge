public class RotateImage48 {

    public void rotate(int[][] matrix) {
        int len = matrix.length-1;
        int l = 0, r = len;
        while (l < r) {
            for (int i = 0; i < r-l; i++) {
                int top = l, bottom = r;

                // save top left
                int topLeft = matrix[top][l + i];

                // move bottom left into top left
                matrix[top][l + i] = matrix[bottom - i][l];

                // move bottom right into bottom left
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // move top right into bottom right
                matrix[bottom][r - i] = matrix[top + i][r];

                // put topLeft value into top right
                matrix[top + i][r] = topLeft;
            }
            l += 1;
            r -= 1;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
