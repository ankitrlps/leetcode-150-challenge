class ZigzagConversion6 {

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length()) return s;
        StringBuilder sb = new StringBuilder();
        
        int highestJump = (numRows - 1) * 2; // highest jump calculated from index 0
        int[] jumps = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            jumps[i] = highestJump;
            highestJump -= 2;
        }

        highestJump = jumps[0];
        int i = 0;
        while (i < jumps.length) {
            int j1 = jumps[i];
            int j2 = Math.abs(highestJump - j1);

            if (j1 == 0 || j2 == 0) { // jump only once with highest jump
                //pickLetters(s, i, highestJump, sb);
                int startIndex = i;
                while (startIndex < s.length()) {
                    sb.append(s.charAt(startIndex));
                    startIndex += highestJump;
                }
            } else { // jump with j1 and j2 intervals separately
                pickLetters(s, i, j1, j2, sb);
            }
            i++;
        }
        return sb.toString();
    }

    private void pickLetters(String s, int startIndex, int j1, int j2, StringBuilder sb) {
        sb.append(s.charAt(startIndex)); // append the start point index and then add j1 then to it, add j2
        while (startIndex + j1 < s.length() || startIndex + j2 < s.length()) {
            if (startIndex + j1 < s.length()) {
                sb.append(s.charAt(startIndex + j1));
            }
            startIndex += j1;
            if (startIndex + j2 < s.length()) {
                sb.append(s.charAt(startIndex + j2));
            }
            startIndex += j2;
        }
    }

    public static void main(String[] args) {
        ZigzagConversion6 zigzag = new ZigzagConversion6();
        System.out.println(zigzag.convert("PAYPALISHIRING", 3));
        System.out.println(zigzag.convert("PAYPALISHIRING", 4));
        System.out.println(zigzag.convert("PAYPALISHIRING", 5));
    }
}