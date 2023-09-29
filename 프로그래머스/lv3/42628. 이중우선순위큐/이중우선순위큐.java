import java.util.*;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String cmd = split[0];
            int num = Integer.parseInt(split[1]);
            
            if (cmd.equals("I")) {
                maxHeap.offer(num);
                minHeap.offer(num);
            } else if (cmd.equals("D")) {
                if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                    continue;
                }
                if (num == 1) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else if (num == -1) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        
        int[] answer = {0, 0};
        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        
        return answer;
    }
}