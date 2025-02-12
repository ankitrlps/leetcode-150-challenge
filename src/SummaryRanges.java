import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            start = i;
            StringBuilder sb = new StringBuilder();
            while (i < nums.length-1 && nums[i] + 1 == nums[i+1]) {
                i++;
            }

            if (i - start > 0) {
                sb.append(nums[start] + "->" + nums[i]);
            } else {
                sb.append(nums[start]);
            }
            list.add(sb.toString());
        }

        return list;
    }
    
    public List<String> summaryRanges1(int[] nums) {
        if (nums.length == 1) return new ArrayList(List.of("" + nums[0]));
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[j-1] + 1) {
                if (i + 1 == j) {
                    list.add("" + nums[i]);
                } else {
                    list.add("" + nums[i] + "->" + nums[j-1]);
                }
                i = j;
            }
            j++;
        }

        if (i <= nums.length-1) {
            if (i == nums.length-1) {
                list.add("" + nums[i]);
            } else {
                list.add("" + nums[i] + "->" + nums[nums.length-1]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        
    }
}
