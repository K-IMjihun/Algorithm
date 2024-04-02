import java.util.*;

class Solution {
    static boolean[] visited; // 사용한 항공권을 표시하기 위한 배열
    static ArrayList<String> allRoute; // 모든 가능한 경로를 저장하는 리스트
    
    public String[] solution(String[][] tickets) {
    String[] answer;
    visited = new boolean[tickets.length];
    allRoute = new ArrayList<>();

    // DFS 시작
    dfs("ICN", "ICN", tickets, 0);

    // 탐색을 마친 후, 알파벳 순서로 정렬
    Collections.sort(allRoute);

    // 가장 먼저 나오는 경로를 반환
    answer = allRoute.get(0).split(" ");

    return answer;
  }

  public static void dfs(String start, String route, String[][] tickets, int cnt) {
    // 모든 항공권을 사용하여 여행 경로를 구성했을 경우
    if (cnt == tickets.length) {
      // 해당 경로를 리스트에 추가
      allRoute.add(route);
      return;
    }

    // 현재 위치에서 출발하여 가능한 모든 항공권을 탐색
    for (int i = 0; i < tickets.length; i++) {
      // 아직 사용되지 않은 항공권 중 현재 위치에서 출발하는 항공권이 있을 경우
      if (start.equals(tickets[i][0]) && !visited[i]) {
        visited[i] = true; // 항공권을 사용했음을 표시
        // 다음 출발지를 도착지로 설정하여 DFS 재귀 호출
        dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
        visited[i] = false; // DFS를 빠져나온 후 방문 표시 해제
      }
    }
  }
}