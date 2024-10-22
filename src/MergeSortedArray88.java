public class MergeSortedArray88 {
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] n1 = new int[m];
        int[] n2 = new int[n];

        for (int i = 0; i < m; i++) {
            n1[i] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            n2[i] = nums2[i];
        }

        int p = 0;
        int q = 0;
        int k = 0;
        while (p < n1.length && q < n2.length) {
            if (n1[p] > n2[q]) {
                nums1[k] = n2[q];
                q++;
            } else {
                nums1[k] = n1[p];
                p++;
            }
            k++;
        }

        while (p < n1.length) {
            nums1[k] = n1[p];
            k++;
            p++;
        }
        while (q < n2.length) {
            nums1[k] = n2[q];
            k++;
            q++;
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{0}, 0, new int[]{1}, 1);
        merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }
}
