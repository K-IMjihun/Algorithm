import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[] isPrime = new boolean[246913]; // 2*123456까지의 소수 판별을 위한 배열

    // 소수 판별
    for (int i = 2; i < 246913; i++) {
      isPrime[i] = true;
    }
    for (int i = 2; i * i < 246913; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j < 246913; j += i) {
          isPrime[j] = false;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) break;

      int count = 0;
      for (int i = n + 1; i <= 2 * n; i++) {
        if (isPrime[i]) count++;
      }
      sb.append(count).append('\n');
    }

    System.out.println(sb);
  }
}