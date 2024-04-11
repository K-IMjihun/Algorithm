import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  static int[][] cabbages;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer;
    int T = Integer.parseInt(br.readLine());
    for(int i = 0; i < T; i++) {
      answer = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      cabbages = new int[M][N];
      visited = new boolean[M][N];
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        cabbages[x][y] = 1;
      }

      for(int j = 0; j < M; j++){
        for(int k = 0; k < N; k++){
          if(cabbages[j][k] == 1 && !visited[j][k]){
            dfs(j, k);
            answer++;
          }
        }
      }

      System.out.println(answer);
    }
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    for(int i = 0; i < 4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if((nx >= 0 && nx < M) && (ny >= 0 && ny < N)){
        if(cabbages[nx][ny] == 1 && !visited[nx][ny]) dfs(nx, ny);
      }
    }
  }
}
