import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 블로그 유지 일 수
    int X = sc.nextInt(); // X일 동안 가장 많이 들어온 방문자 수
    int[] visitors = new int[N + 1];

    // 방문자 수 입력 및 누적합 계산
    for (int i = 1; i <= N; i++) {
      visitors[i] = visitors[i - 1] + sc.nextInt();
    }

    int maxVisitors = 0;
    int maxVisitsCount = 0;

    // X일 동안의 방문자 수 계산
    for (int i = X; i <= N; i++) {
      int sum = visitors[i] - visitors[i - X];
      if (sum > maxVisitors) {
        maxVisitors = sum;
        maxVisitsCount = 1;
      } else if (sum == maxVisitors) {
        maxVisitsCount++;
      }
    }

    if (maxVisitors == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(maxVisitors);
      System.out.println(maxVisitsCount);
    }
  }
}
