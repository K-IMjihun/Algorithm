import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int F = sc.nextInt();
    int answer = (N/100) * 100;
    while (answer % F != 0) answer++;
    System.out.printf("%02d", answer % 100);
  }
}