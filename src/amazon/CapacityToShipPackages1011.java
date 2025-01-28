package amazon;

public class CapacityToShipPackages1011 {

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        
        int res = right;
        while (left <= right) {
            int midCap = left + (right - left) / 2;

            if (canShip(midCap, weights, days)) {
                res = Math.min(res, midCap);
                right = midCap - 1;
            } else {
                left = midCap + 1;
            }
        }

        return res;
    }

    private static boolean canShip(int cap, int[] weights, int days) {
        int ships = 1;
        int currCap = cap;

        for (int weight : weights) {
            if (currCap - weight < 0) {
                ships++;
                if (ships > days) return false;
                currCap = cap;
            }
            currCap -= weight;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{9,2,4,6}, 3));
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
