import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
                Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) {
            q1.add((long) num);
            sum1 += num;
        }
        for (int num : queue2) {
            q2.add((long) num);
            sum2 += num;
        }

        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) return -1;
        
        long target = totalSum / 2;
        int maxOperations = queue1.length * 3;
        int operations = 0;
        
        while (sum1 != target && operations < maxOperations) {
            if (sum1 > target) {
                long value = q1.poll();
                q2.add(value);
                sum1 -= value;
                sum2 += value;
            } else {
                long value = q2.poll();
                q1.add(value);
                sum1 += value;
                sum2 -= value;
            }
            operations++;
        }

        return (sum1 == target) ? operations : -1;
    }
}
