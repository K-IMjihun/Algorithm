import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int t, N, M, count;
  // dp 배열 :(문제 조건) N,M이 최대 30
  static int[][] dp = new int[30][30];
  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for(int T=0 ; T<t;T++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      count = 0;

      N = Math.min(N,(M-N));


      for(int i = 0; i < 30; i++) {
        dp[i][i] = 1;
        dp[i][0] = 1;
      }


      for(int i = 2; i < 30; i++) {
        for(int j = 1; j < 30; j++) {
          dp[i][j] =dp[i - 1][j]+dp[i - 1][j - 1];

        }
      }
      System.out.println(dp[M][N]);
    }
  }
}