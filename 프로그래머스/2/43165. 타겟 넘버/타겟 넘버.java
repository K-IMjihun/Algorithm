import java.util.*;
    
class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target, int d, int sum){
        if(numbers.length == d){
            if(target == sum){
                answer++;
            }
        }
        else{
            dfs(numbers, target, d+1, sum + numbers[d]);
            dfs(numbers, target, d+1, sum - numbers[d]);
        }
    }
}