class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int []maxsize = new int[2];
        for(int i = 0; i < sizes.length; i++){
            maxsize[0] = (maxsize[0] < Math.max(sizes[i][0], sizes[i][1]))?
                Math.max(sizes[i][0], sizes[i][1]) : maxsize[0];
            maxsize[1] = (maxsize[1] < Math.min(sizes[i][0], sizes[i][1]))?
                Math.min(sizes[i][0], sizes[i][1]) : maxsize[1];
        }
        answer = maxsize[0] * maxsize[1];
        return answer;
    }
}