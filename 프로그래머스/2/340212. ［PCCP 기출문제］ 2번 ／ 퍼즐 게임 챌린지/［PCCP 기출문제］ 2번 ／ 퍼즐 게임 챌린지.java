class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1; // 숙련도는 최소 1부터 시작
        int right = 100000; // diffs[i]의 최대값인 100000까지

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 현재 숙련도로 모든 퍼즐을 제한 시간 내에 풀 수 있는지 확인
            if (calculateTotalTime(mid, diffs, times) <= limit) {
                right = mid; // 가능한 경우, 더 낮은 숙련도를 탐색
            } else {
                left = mid + 1; // 불가능한 경우, 더 높은 숙련도를 탐색
            }
        }

        return left;
    }
    
    
    public long calculateTotalTime(int level, int[] diffs, int[] times) {
        long totalTime = 0;
        int n = diffs.length;

        for (int i = 0; i < n; i++) {
            int diff = diffs[i];
            int timeCur = times[i];
            int timePrev = (i > 0) ? times[i - 1] : 0;

            if (diff <= level) {
                // 숙련도가 충분히 높아 틀리지 않고 푼 경우
                totalTime += timeCur;
            } else {
                // 숙련도가 부족해 틀리는 경우
                int mistakes = diff - level;
                totalTime += (long) mistakes * (timeCur + timePrev) + timeCur;
            }
        }

        return totalTime;
    }
}