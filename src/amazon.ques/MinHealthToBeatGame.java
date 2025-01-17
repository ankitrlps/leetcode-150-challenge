
public class MinHealthToBeatGame {
    static int minHealth(int[] damage, int armor) {
        int sum = 0;
        int max = 0;
        for (int i : damage) {
            sum += i;
            max = Math.max(max, i);
        }

        return sum - Math.min(max, armor) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minHealth(new int[]{2, 7, 4, 3}, 4));
        System.out.println(minHealth(new int[]{2, 5, 3, 4}, 7));
        System.out.println(minHealth(new int[]{3, 3, 3}, 0));
        System.out.println(minHealth(new int[]{1, 2, 6, 7}, 5));
    }
}
