import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
     int n = book_time.length;
        int[][] times = new int[n][2];
        
        // 예약 시간을 분 단위로 변환
        for (int i = 0; i < n; i++) {
            times[i][0] = convertToMinutes(book_time[i][0]); // 시작 시간
            times[i][1] = convertToMinutes(book_time[i][1]) + 10; // 종료 시간 + 청소 시간
        }
        
        // 시작 시간을 기준으로 정렬
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        
        // 종료 시간을 저장할 우선순위 큐 (최소 힙)
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();
        
        for (int[] time : times) {
            int startTime = time[0];
            int endTime = time[1];
            
            // 청소까지 끝난 시각보다 빠른 종료 시간을 가진 방을 반환
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= startTime) {
                roomEndTimes.poll();
            }
            
            // 새로운 종료 시간 추가
            roomEndTimes.offer(endTime);
        }
        
        // 우선순위 큐의 크기가 필요한 최소 방의 개수
        return roomEndTimes.size();
    }
    
    // 시간을 분으로 변환하는 함수
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}