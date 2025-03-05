public class AddBinary67 {

    public String addBinary(String a, String b) {
        int l1 = a.length()-1;
        int l2 = b.length()-1;
        int max = Math.max(l1, l2);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (max >= 0) {
            int aa = l1 >= 0 ? Character.getNumericValue(a.charAt(l1--)) : 0;
            int bb = l2 >= 0 ? Character.getNumericValue(b.charAt(l2--)) : 0;
            int sum = aa + bb + carry;
            carry = 0;
            if (sum == 2) {
                carry = 1;
                sum = 0;
            } else if (sum == 3) {
                carry = 1;
                sum = 1;
            }
            sb.append(sum);
            max--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        
    }
}
