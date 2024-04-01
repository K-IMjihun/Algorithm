import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
       int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt(arr -> arr[2]));
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int[] cost: costs){
            int fromParent = findParent(cost[0]);
            int toParent = findParent(cost[1]);

            // 두 노드가 같은 집합에 속하지 않으면 연결하고 비용을 더함
            if(fromParent != toParent) {
                answer += cost[2];
                parent[toParent] = fromParent;
            }
        }
        // System.out.println(answer);
        return answer;
    }

    private static int findParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
}