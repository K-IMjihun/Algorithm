import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int M;
  static int[][] board;
  static int[][][] dp;
  static int[] dx = {-1, 0, 1};
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    N = Integer.parseInt(s[0]);
    M = Integer.parseInt(s[1]);

    board = new int[N][M];
    dp = new int[N][M][3];
    for(int i = 0; i < N; i++) {
      s = br.readLine().split(" ");
      for(int j = 0; j < M; j++) {
        Arrays.fill(dp[i][j], -1);
        board[i][j] = Integer.parseInt(s[j]);
      }
    }

    for(int i = 0; i < M; i++) {
      move(0, i, -1, 0);
    }

    System.out.println(min);
  }
  // r: 현재 행의 위치
  // c: 현재 열의 위치
  // dir: 이동하려는 방향 (0: 왼쪽, 1: 아래, 2: 오른쪽)
  // sum: 현재까지 이동한 칸들의 합
  static void move(int row, int column, int dir, int sum) {
    if(row == N) {
      min = Math.min(min, sum);
      return;
    }

    for(int i = 0; i < 3; i++) {
      if(dir == i) continue; // 방문한 적이 있을 경우
      int nx = column + dx[i]; // 다음 열의 위치
      if(nx >= 0 && nx < M) { // 다음 열의 위치가 0보다 크거나 같고, M을 초과하지 않을 경우 재귀호출
        move(row + 1, nx, i, sum + board[row][column]);
      }
    }
  }
}