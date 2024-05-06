import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {  
        int answer = 0;
  int sum = 0;
  Map<Integer, Integer> map = new HashMap<>();
  for(int number : tangerine){
    map.put(number, map.getOrDefault(number, 0) + 1);
  }
    ArrayList<Integer> valueList = new ArrayList<>(map.values());
    valueList.sort(Collections.reverseOrder());
    for(int value : valueList){
      if(sum + value >= k){
        answer++;
        break;
      } 
      else {
        sum += value;
        answer++;
      }
    }
//    System.out.println(answer);
    return answer;
  }
}