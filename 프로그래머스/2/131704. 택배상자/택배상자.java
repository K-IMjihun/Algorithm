import java.util.Stack;

public class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int count = 0;
        
        for (int i = 1; i <= order.length; i++) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                index++;
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] order1 = {4, 3, 1, 2, 5};
        System.out.println(solution.solution(order1)); // 2
        
        int[] order2 = {5, 4, 3, 2, 1};
        System.out.println(solution.solution(order2)); // 5
    }
}
