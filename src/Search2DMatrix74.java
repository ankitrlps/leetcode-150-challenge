public class Search2DMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (arr[0] <= target && target <= arr[arr.length-1]) {
                //return Arrays.binarySearch(arr, target) >= 0;
                int left = 0;
                int right = arr.length-1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] == target) return true;
                    if (arr[mid] < target) {
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
    }
}
