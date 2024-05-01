import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int[][] A = new int[N][2];
    int[] B = new int[N];

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < N; i++) {
      A[i][0] = sc.nextInt();
      A[i][1] = i;
    }

    sort(A);

    for (int i = 0; i < N; i++) {
      int index = A[i][1];
      B[index] = i;
    }

    for (int b : B) {
      builder.append(b).append(" ");
    }

    System.out.println(builder.toString().trim());
  }
  private static void sort(int[][] A) {
    Arrays.sort(A, (next, current) -> {
      if (next[0] < current[0]) {
        return -1;
      }
      else if (next[0] > current[0]) {
        return 1;
      }
      else {
        return Integer.compare(next[1], current[1]);
      }
    });
  }
}
