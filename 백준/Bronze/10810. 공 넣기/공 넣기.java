import java.util.*;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] arr = new int[N];

    for (int m = 0; m < M; m++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      for (int i = a - 1; i <= b - 1; i++) {
        arr[i] = c;
      }
    }
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
