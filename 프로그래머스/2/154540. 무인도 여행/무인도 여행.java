import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                grid[i][j] = (c == 'X') ? 0 : c - '0';
            }
        }
        
        List<Integer> results = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int days = bfs(grid, visited, i, j);
                    results.add(days);
                }
            }
        }
        
        if (results.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(results);
        return results.stream().mapToInt(i -> i).toArray();
    }
    
    private int bfs(int[][] grid, boolean[][] visited, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int days = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                days += grid[r][c];
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] > 0 && !visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return days;
    }
}
