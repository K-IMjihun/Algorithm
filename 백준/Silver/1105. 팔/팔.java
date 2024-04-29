import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String min = sc.next();
    String max = sc.next();
    int answer = 0;
    if(min.length() != max.length());
    else {
      for (int i = 0; i < min.length() && min.charAt(i) == max.charAt(i); i++) {
        if (min.charAt(i) == '8') {
          answer++;
        }
      }
    }
    System.out.println(answer);
  }
}
