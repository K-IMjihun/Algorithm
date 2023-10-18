class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] b = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!b[i]){
            dfs(computers, i, b);
            answer++;
            }
        }
        return answer;
    }
    
    boolean[] dfs(int[][] computers, int i, boolean[] b){
        b[i] = true;
        for(int j = 0; j < computers.length; j++){
            if(i != j && computers[i][j] == 1 && b[j] == false){
                b = dfs(computers, j, b);
            }
        }
    return b;
    }
}