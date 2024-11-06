
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom380 {

    class RandomizedSet {

        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Random random = new Random();

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1); // storing the list index as map's value
            return true;
        }
        // [1,2,3,4,5,6]
        //  0,1,2,3,4,5
        // [1,2,3,6,5]
        //  0,1,2,3,4

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);
            // swapping with last element in list and updating map with last element's index
            map.put(lastElement, index);
            list.set(index, lastElement);

            map.remove(val);
            // removing last element as we have saved it in the index who's val was removed.
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            //Integer[] nums = map.keySet().toArray(new Integer[0]);
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        
    }
}


// Easy and less space but takes a lot time of 128 ms
//     class RandomizedSet {
//     private Map<Integer, Integer> map;
//     private Random random = new Random();
//     public RandomizedSet() {
//         map = new HashMap<>();
//     }
//     public boolean insert(int val) {
//         if (map.containsKey(val)) return false;
//         map.put(val, 0);
//         return true;
//     }
//     public boolean remove(int val) {
//         if (map.remove(val) != null) {
//             return true;
//         }
//         return false;
//     }
//     public int getRandom() {
//         Integer[] nums = map.keySet().toArray(new Integer[0]);
//         return nums[random.nextInt(nums.length)];
//     }
// }