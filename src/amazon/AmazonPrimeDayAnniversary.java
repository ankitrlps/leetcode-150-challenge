package amazon;

public class AmazonPrimeDayAnniversary {

    static int getMaxDiscountPairs(int[] products) {
        int pairs = 0;
        for (int i = 0; i < products.length; i++) {
            for (int j = i+1; j < products.length; j++) {
                if ((products[i] + products[j]) % 3 == 0) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
    
    public static void main(String[] args) {
        System.out.println(getMaxDiscountPairs(new int[]{2,1,8}));
    }
}
