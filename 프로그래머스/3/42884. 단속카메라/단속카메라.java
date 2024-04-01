import java.util.*;
class Solution {
    public int solution(int[][] routes) {
  int answer = 0;
  int min = Integer.MIN_VALUE;
  // 나가는 시간으로 오름차순 정렬
  Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

  for(int[] route : routes){
    // 현재 차량이 나가는 시간보다 다음 차량의 들어오는 시간이 더 늦을경우
    if(min < route[0]){
      min = route[1]; // 기준(현재 차량이 나가는 시간)을 다음 차량으로 변경
      answer++;       // 카메라 한대 더 설치
    }
  }
  return answer;
//    System.out.println(answer);
  }

}