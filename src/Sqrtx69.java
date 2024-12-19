
public class Sqrtx69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1;
        int end = x;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((long) mid * (long) mid > x) {
                end = mid - 1;
            } else if (mid * mid == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        System.out.println((int) Math.sqrt(17));
    }

}
