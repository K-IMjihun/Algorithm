import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    double sqrt;
    for(int i = M; i <= N; i++){
      sqrt = (int)Math.sqrt(i);
      boolean divisor = true;
      if(i == 0 || i == 1){
        divisor = false;
      }
      for(int j = 2; j <= sqrt; j++){
        if (i % j == 0){
          divisor = false;
          break;
        }
      }
      if(divisor == true){
        System.out.println(i);
      }
    }
  }
}
