import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int countZero = 0;
        String binary = "";
        int count = 0;

        while (!s.equals("1")) {
            String text = s.replace("0", "");
            countZero += s.length() - text.length();
            int textLength = text.length();
            binary = Integer.toBinaryString(textLength);
            s = binary;
            count += 1;
        }
        answer = new int[]{count, countZero};
        return answer;
    }
}
