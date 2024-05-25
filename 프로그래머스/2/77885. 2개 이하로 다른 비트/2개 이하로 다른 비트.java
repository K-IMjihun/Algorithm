public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            if (x % 2 == 0) {
                // 짝수일 때는 그냥 x + 1
                answer[i] = x + 1;
            } else {
                // 홀수일 때는 다음의 방법으로 계산
                long bit = 1;
                while ((x & bit) != 0) {
                    bit <<= 1;
                }
                bit >>= 1;
                answer[i] = x + bit;
            }
        }

        return answer;
    }
}