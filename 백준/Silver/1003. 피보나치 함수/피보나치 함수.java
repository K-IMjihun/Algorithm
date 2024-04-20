import java.util.Scanner;

public class Main {
  static long zeroCount;
  static long oneCount;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      zeroCount = 0;
      oneCount = 0;
      fibonacci(N);
      System.out.println(zeroCount + " " + oneCount);
    }
  }

  private static void fibonacci(int n) {
    int temp1 = 0;
    int temp2 = 1;
    int temp = 0;

    if(n==0) {
      zeroCount++;
      return;
    } else if(n== 1) {
      oneCount++;
      return;
    } else if(n < 0) return;
    else {
      for(int i = 1 ; i < n ; i++) {
        temp = temp1 + temp2;
        temp1 = temp2;
        temp2 = temp;
      }
      zeroCount = temp1;
      oneCount = temp2;
    }
  }
}