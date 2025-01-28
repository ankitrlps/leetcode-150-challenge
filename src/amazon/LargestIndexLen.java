package amazon;

public class LargestIndexLen {

    static int getLargestIndexLen(int[] feature1, int[] feature2) {
        if (feature1.length != feature2.length) return 0;

        int len = feature1.length;
        int start = -1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if ((feature1[i] < feature1[j] && feature2[i] < feature2[j]) ||
                    (feature1[i] > feature1[j] && feature2[i] > feature2[j])) {
                        if (start == -1) {
                            start = i;
                        }
                } else {
                    if (start != -1) res = Math.max(res, j - start);
                    start = -1;
                }
            }
        }
        if (start != -1) {
            res = Math.max(res, len-start);
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(getLargestIndexLen(new int[]{4,5,3,1,2}, new int[]{2,1,3,4,5}));
        System.out.println(getLargestIndexLen(new int[]{4,5,3,1,2,3}, new int[]{2,1,3,4,5,2}));
        System.out.println(getLargestIndexLen(new int[]{4,5,0,1,2,3}, new int[]{2,1,3,4,5,2}));
    }
}
