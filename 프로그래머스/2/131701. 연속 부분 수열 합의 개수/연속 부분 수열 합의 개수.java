import java.util.*;
class Solution {
    public int solution(int[] elements) {
    int answer = 0;
    int n = elements.length;
    Set<Integer> sumSet = new HashSet<>();

    // 원형 수열을 구하기 위해 기존 수열을 두 번 이어붙임
    int[] circularElements = new int[n * 2];
    for (int i = 0; i < n * 2; i++) {
      circularElements[i] = elements[i % n];
    }

    // 모든 부분 수열의 합을 구함
    for (int i = 0; i < n; i++) {
      for (int j = i; j < i + n; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += circularElements[k];
        }
        sumSet.add(sum);
      }
    }
    answer = sumSet.size();

    // System.out.println(answer);
   return answer;
  }
}