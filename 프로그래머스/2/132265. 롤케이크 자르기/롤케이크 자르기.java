import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int n = topping.length;
    Set<Integer> leftSet = new HashSet<>();
    int[] leftCount = new int[n];

    for (int i = 0; i < n; i++) {
      leftSet.add(topping[i]);
      leftCount[i] = leftSet.size();
    }

    Set<Integer> rightSet = new HashSet<>();
    int[] rightCount = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      rightSet.add(topping[i]);
      rightCount[i] = rightSet.size();
    }

    int ways = 0;
    for (int i = 0; i < n - 1; i++) {
      if (leftCount[i] == rightCount[i + 1]) {
        ways++;
      }
    }
    // System.out.println(ways);
   return ways;
  }
}