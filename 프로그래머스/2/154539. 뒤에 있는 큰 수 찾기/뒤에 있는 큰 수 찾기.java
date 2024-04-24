import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>(); // numbers 를 넣을 stack
    int[] answer = new int[numbers.length];

    // numbers 의 첫번째 값을 stack 에 넣음
    stack.push(0);

    // 두 번째 원소부터 numbers 탐색
    for (int i = 1; i < numbers.length; i++) {
      while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
      answer[stack.pop()] = numbers[i];
      }
      stack.push(i);
    }
        
    //뒤에 있는 큰 수가 없는 경우
    while (!stack.isEmpty()) {
      answer[stack.pop()] = -1;
    }
        
    return answer;
  }
}