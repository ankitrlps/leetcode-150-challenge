import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class MinGeneticMutation433 {

    public int minMutation(String start, String end, String[] bank) {
        int levels = 0;

        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.add(start);
        visited.add(start);
        char[] geneChoice = {'A', 'C', 'G', 'T'};

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                String curr = que.poll();
                if (curr.equals(end)) return levels;

                char[] ch = curr.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char tempStore = ch[i];
                    for (char choice : geneChoice) {
                        ch[i] = choice;
                        String newGene = new String(ch);
                        if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                            que.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    ch[i] = tempStore;
                }
                
            }
            if (que.isEmpty()) return -1;
            levels++;
        }

        return levels;
    }

    public static void main(String[] args) {
        MinGeneticMutation433 geneticMutation433 = new MinGeneticMutation433();
        //System.out.println(geneticMutation433.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        System.out.println(geneticMutation433.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
    }
}
