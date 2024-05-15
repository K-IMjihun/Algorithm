class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        // 배열의 모든 요소들의 최소공배수를 계산
        for (int i = 1; i < arr.length; i++) {
            lcm = getLCM(lcm, arr[i]);
        }
        
        return lcm;
    }
    
    // 최대공약수 계산 함수
    public int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    // 최소공배수 계산 함수
    public int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }
}