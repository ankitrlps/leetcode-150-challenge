import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule207 {

    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //if (prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();

        //building adj list
        for (int[] pre : prerequisites) {
            if (map.containsKey(pre[0])) {
                map.get(pre[0]).add(pre[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pre[1]);
                map.put(pre[0], list);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map)) return false;
        }
        return true;
    }


    boolean dfs(int courseIndex, Map<Integer, List<Integer>> map) {
        if (visited.contains(courseIndex)) return false;

        if (!map.containsKey(courseIndex)) {
            return true;
        }
        
        visited.add(courseIndex);        

        for (int l : map.get(courseIndex)) {
            if (!dfs(l, map)) return false;
        }

        visited.remove(courseIndex);
        map.put(courseIndex, new ArrayList<>());
        return true;
    }

    public static void main(String[] args) {
        
    }
}
