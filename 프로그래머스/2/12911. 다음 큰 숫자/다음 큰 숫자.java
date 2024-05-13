class Solution {
    public int solution(int n) {
        int answer = 0;
        int countN = countOne(n);
        for (int i = n + 1; ; i++) {
            if (countOne(i) == countN) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int countOne(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }
        
        return count;
    }
}