import java.util.*;

class Main {

  static int[] constructionTime;
  static List<List<Integer>> graph;
  static int[] inDegree;

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      building();
    }
  }

  private static void building() {
    int N = sc.nextInt();
    int K = sc.nextInt();
    constructionTime = new int[N + 1];
    inDegree = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      constructionTime[i] = sc.nextInt();
    }

    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < K; i++) {
      int X = sc.nextInt();
      int Y = sc.nextInt();
      graph.get(X).add(Y); 
      inDegree[Y]++;
    }

    int W = sc.nextInt();
    System.out.println(getMinimumTime(N, W));
  }

  private static int getMinimumTime(int N, int W) {
    int[] dp = new int[N + 1];
    Arrays.fill(dp, -1); // 초기값 -1로 설정

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
        dp[i] = constructionTime[i];
      }
    }

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      for (int next : graph.get(curr)) {
        dp[next] = Math.max(dp[next], dp[curr] + constructionTime[next]);
        inDegree[next]--;
        if (inDegree[next] == 0) {
          queue.offer(next);
        }
      }
    }

    return dp[W];
  }
}
