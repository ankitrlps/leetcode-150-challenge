public class TwoSumII167 {

    // TC: O(n) Two pointer
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0, j = numbers.length-1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }
        }
        return res;
    }

    // TC: O(n^2)
    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        int sum = numbers[0];
        int i = 1;

        while (i < numbers.length) {
            sum += numbers[i];
            if (sum >= target) {
                res[1] = i+1; // store the current element because it's the one which made sum >= target
                int j = i-1; // start searching for other compliment starting from i-1
                int searchCompliment = target-numbers[i];
                while (j >= 0 && numbers[j] != searchCompliment) { // search backwards to find the compliment
                    j--;
                }
                if (j >= 0) { // this means we got the other compliment that in the index range, store it and break
                    res[0] = j+1;
                    break;
                } // else there is no other compliment found, so continue searching for other elements using 'i'
            }
            if (target >= 0 && sum < 0) { // Edge case: if target is >= 0 && so far sum is negatives, then no point of using that sum, hence set to 0 
                sum = 0;
            }
            i++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        
    }
}
