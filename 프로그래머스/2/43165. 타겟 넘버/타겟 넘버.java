import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public static int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return dfs(numbers, target, index + 1, sum + numbers[index])
                    + dfs(numbers, target, index + 1, sum - numbers[index]);
        }
    }
}