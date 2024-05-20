import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    long answer = 0;
    for(int work : works){
      queue.offer(work);
    }
    for(int i = 0; i < n; i++){
      if(queue.peek() <= 0) break;
      queue.offer(queue.poll() - 1);
    }
    while (!queue.isEmpty()){
      if(queue.peek() <= 0) break;
      answer += Math.pow(queue.poll(), 2);
    }
    // System.out.println(answer);
    return answer;
  }
}