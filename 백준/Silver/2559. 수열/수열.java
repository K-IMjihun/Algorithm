import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 입력받을 온도의 갯수
        int K = sc.nextInt(); // 합쳐야 하는 일수

        int[] arr = new int[N];
        int[] ct = new int[N + 1];
        int max = Integer.MIN_VALUE;

        // 배열 초기화 및 첫 번째 요소 누적 온도 설정
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (i == 0) {
                ct[i + 1] = arr[i];
            } else {
                ct[i + 1] = ct[i] + arr[i];
            }
        }

        // 연속적인 K일의 온도의 합이 최대가 되는 값 탐색
        for (int i = 1; i <= N - K + 1; i++) {
            int temp = ct[i + K - 1] - ct[i - 1];
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}