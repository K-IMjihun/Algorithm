import java.util.*;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    StringBuilder answer = new StringBuilder();
    String[] arr = new String[N];
    for(int i = 0; i < N; i++){
      arr[i] = sc.next();
    }

    for(int i = 0; i < arr[0].length(); i++){
      char charCheck = arr[0].charAt(i);
      for(int j = 0; j < N; j++){
        if(charCheck != arr[j].charAt(i)) {
          answer.append("?");
          break;
        }
        else if(j == N-1 && charCheck == arr[j].charAt(i)) answer.append(charCheck);
      }
    }
    System.out.println(answer);
  }
}
