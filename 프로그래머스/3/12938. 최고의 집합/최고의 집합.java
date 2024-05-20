import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int quotient = s / n;
        int remainder = s % n;
        
        if (quotient == 0) {
            return new int[]{-1};
        }
        
        Arrays.fill(answer, quotient);
        
        for (int i = 0; i < remainder; i++) {
            answer[n - i - 1]++;
        }
        
        return answer;
    }
}