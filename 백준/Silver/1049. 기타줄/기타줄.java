import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int answer = 0;
    int[] strings = new int[M];
    int[] string = new int[M];
    for(int i = 0; i < M; i++){
      strings[i] = sc.nextInt();
      string[i] = sc.nextInt();
    }
    Arrays.sort(strings);
    Arrays.sort(string);
    int minStrings = strings[0];
    int minString = string[0];
    while(N > 0){
      // 기타줄을 낱개로 살때보다 세트로 살 때, 더 싼경우
      if(minStrings < minString * Math.min(6, N)){
        answer += strings[0];
        N -= 6;
      }

      else{
        answer += minString * N;
        N = 0;
      }
    }
    System.out.println(answer);
  }
}
