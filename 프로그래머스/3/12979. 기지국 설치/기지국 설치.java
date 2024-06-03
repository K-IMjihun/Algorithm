public class Solution {
    public int solution(int N, int[] stations, int W) {
        int answer = 0;
        int coverage = 2 * W + 1; // 하나의 기지국이 커버할 수 있는 범위

        int start = 1; // 처음부터 시작
        for (int station : stations) {
            // 현재 기지국이 커버하는 범위 시작점
            int leftCoverage = station - W;
            
            // 현재 기지국이 커버하지 못하는 구간이 있는지 확인
            if (start < leftCoverage) {
                // 현재 커버되지 않는 구간 길이
                int gap = leftCoverage - start;
                
                // 커버되지 않는 구간을 커버하기 위해 필요한 기지국 개수
                answer += (gap + coverage - 1) / coverage; // 올림 계산
            }
            
            // 다음 커버리지 시작점은 현재 기지국 커버리지 끝 다음
            start = station + W + 1;
        }

        // 마지막 기지국 이후의 구간 커버 여부 확인
        if (start <= N) {
            int gap = N - start + 1;
            answer += (gap + coverage - 1) / coverage;
        }

        return answer;
    }
}