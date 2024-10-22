import java.util.*;

public class Solution {

    // 델타 배열을 이용하여 상하좌우로 이동할 수 있는 방향 정의
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    // 땅의 크기
    static int n, m;
    
    // 땅의 정보를 저장하는 배열
    static int[][] land;
    
    // 방문 여부를 확인하는 배열
    static boolean[][] visited;
    
    // 석유 덩어리 크기 정보를 저장하는 맵 (덩어리 번호 -> 덩어리 크기)
    static Map<Integer, Integer> oilSizeMap = new HashMap<>();
    
    // 각 칸이 속한 덩어리 번호를 저장하는 배열
    static int[][] chunkMap;
    
    // 덩어리 번호를 카운트하는 변수
    static int chunkId = 0;
    
    public static int solution(int[][] landInput) {
        land = landInput;
        n = land.length;
        m = land[0].length;
        
        visited = new boolean[n][m];
        chunkMap = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    chunkId++;
                    int oilSize = bfs(i, j, chunkId);
                    oilSizeMap.put(chunkId, oilSize);
                }
            }
        }
        int maxOil = 0;
        for (int col = 0; col < m; col++) {
            maxOil = Math.max(maxOil, getOilAmountByDrill(col));
        }
        
        return maxOil;
    }
    
    private static int bfs(int x, int y, int chunkId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        chunkMap[x][y] = chunkId;
        int oilSize = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            oilSize++;
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    chunkMap[nx][ny] = chunkId;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        return oilSize;
    }
    
    private static int getOilAmountByDrill(int col) {
        Set<Integer> chunkIds = new HashSet<>();
        int totalOil = 0;
        
        for (int row = 0; row < n; row++) {
            if (chunkMap[row][col] != 0) {
                int chunkId = chunkMap[row][col];
                if (!chunkIds.contains(chunkId)) {
                    totalOil += oilSizeMap.get(chunkId);
                    chunkIds.add(chunkId);
                }
            }
        }
        return totalOil;
    }
}
