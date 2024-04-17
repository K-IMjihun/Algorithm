import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    char[][] arr = new char[M][N];
    int answer = 1;
    
    for (int i = 0; i < M; i++) {
      String numbers = sc.next();
      for (int j = 0; j < numbers.length(); j++) arr[i][j] = numbers.charAt(j);
    }

    int length = Math.min(M, N);
    label : while (length > 1) {
      for (int i = 0; i <= M - length; i++) {
        for (int j = 0; j <= N - length; j++) {
          char vertexNumber = arr[i][j];
          if (vertexNumber == arr[i][j + length - 1] &&
              vertexNumber == arr[i + length - 1][j] &&
              vertexNumber == arr[i + length - 1][j + length - 1]) {
            answer = length * length;
            break label;
          }
        }
      }
      length--;
    }
    System.out.println(answer);
  }
}
