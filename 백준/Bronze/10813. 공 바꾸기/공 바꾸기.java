import java.util.*;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] arr = new int[N];
    for(int i = 0; i < N; i++){
      arr[i] = i;
    }

    for(int i = 0; i < M; i++){
      int a = sc.nextInt()-1;
      int b = sc.nextInt()-1;

      int temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
    }
    for(int i : arr){
      System.out.print(i + 1 + " ");
    }
  }
}
