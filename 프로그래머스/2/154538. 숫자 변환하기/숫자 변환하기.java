import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
     Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        // 방문 여부를 저장하는 배열
        boolean[] visited = new boolean[y + 1];
        visited[x] = true;
        
        // 연산 횟수를 저장하는 배열
        int[] count = new int[y + 1];
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == y) {
                return count[current];
            }
            
            // 현재 숫자에 각각의 연산을 적용하여 새로운 숫자 생성
            int[] nextNumbers = {current + n, current * 2, current * 3};
            
            for (int next : nextNumbers) {
                // 범위를 벗어나거나 이미 방문한 숫자인 경우 스킵
                if (next <= y && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count[next] = count[current] + 1;
                }
            }
        }
        // 연산을 통해 y를 만들 수 없는 경우
        return -1;
    }

}