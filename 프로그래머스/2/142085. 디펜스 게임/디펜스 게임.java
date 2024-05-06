import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
    int answer = 0;
    if(enemy.length == k) answer = enemy.length;
    else {
      int enemyNumber = 0; // 적의 인원
      PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
      for(int number : enemy){
        enemyNumber += number;
        queue.offer(number);
          // 적의 인원이 병사보다 많을 경우
        if(enemyNumber > n){
            // 무적권이 있을 경우
          if(k > 0){
            --k;
              //우선순위 큐를 사용하여 가장 큰 값 제거
            enemyNumber -= queue.poll();
          }
          else break;
        }
        answer++;
      }
    }
//    System.out.println(answer);
    return answer;
  }
}
