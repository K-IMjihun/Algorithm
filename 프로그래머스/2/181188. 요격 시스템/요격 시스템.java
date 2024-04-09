import java.util.*;

class Solution {
    public int solution(int[][] targets) {
Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));
    int[] beforeTarget = {-1,-1};
    int answer = 0;
    for(int[] target : targets){
      if(!(beforeTarget[1] > target[0])){
        answer++;
        beforeTarget[0] = target[0];
        beforeTarget[1] = target[1];
      }

    }
    // System.out.println(answer);
        return answer;
    }
}