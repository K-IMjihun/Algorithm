class Solution {
    public int solution(int n, int m, int[] section) {
                int answer = 1;
        int startNumber = section[0];
        for(int i = 1; i < section.length; i++) {
        if(startNumber + m - 1 < section[i]){
            answer++;
            startNumber = section[i];
        }
        }
        return answer;
    }
}