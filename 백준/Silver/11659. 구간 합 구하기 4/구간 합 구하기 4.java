import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] numbers = new int[N]; //수 저장
    int[] prefixSum = new int[N + 1]; //합 저장

    for (int i = 0; i < N; i++) {
      numbers[i] = sc.nextInt();
    }

    // 합 계산
    for (int i = 0; i < N; i++) {
      prefixSum[i + 1] = prefixSum[i] + numbers[i];
    }
    
    for (int i = 0; i < M; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int sum = prefixSum[end] - prefixSum[start - 1];
      System.out.println(sum);
    }
  }
}