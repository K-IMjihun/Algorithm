import java.util.*;
class Solution {
    int solution(int[][] land) {
        int[] prev = land[0];
        
        for (int i = 1; i < land.length; i++) {
            int[] curr = new int[4];
            curr[0] = land[i][0] + Math.max(Math.max(prev[1], prev[2]), prev[3]);
            curr[1] = land[i][1] + Math.max(Math.max(prev[0], prev[2]), prev[3]);
            curr[2] = land[i][2] + Math.max(Math.max(prev[0], prev[1]), prev[3]);
            curr[3] = land[i][3] + Math.max(Math.max(prev[0], prev[1]), prev[2]);
            prev = curr;
        }
        
        return Math.max(Math.max(prev[0], prev[1]), Math.max(prev[2], prev[3]));
    }
}