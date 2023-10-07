class Solution {  
    static boolean[] visited;  
    static int answer = -1;  
  
    public int solution(int k, int[][] dungeons) {  
        visited = new boolean[dungeons.length];  
        dfs(0, k, dungeons);  
        return answer;  
    }  
      
    private void dfs(int depth, int fatigue, int[][] dungeons){  
        for (int i = 0; i < dungeons.length; i++){  
            // visited[i]가 true거나, 내 피로도보다 요구 피로도가 클 경우
            if (visited[i] || dungeons[i][0] > fatigue) {  
                continue;  
            }  
            // 던전 탐색이 가능 할 경우
            // '깊이 +1, 피로도 - 던전 소모 피로도, 던전' 으로 재귀호출
            // 수행 후, visited[i]값을 false로 초기화
            visited[i] = true;  
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);  
            visited[i] = false;  
        }  
        answer = Math.max(answer, depth);  
    }  
}