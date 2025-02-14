package random;

import java.util.Arrays;

public class MaximumUnitsOnTruck1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1]));
        int max = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize - boxType[0] >= 0) {
                truckSize -= boxType[0];
                max += boxType[0] * boxType[1];
            } else {
                max += truckSize * boxType[1];
                return max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        
    }
}
