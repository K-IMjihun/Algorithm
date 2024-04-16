import java.util.Scanner;

public class Main {
  static int totalX, totalY, target, vx, vy;
  static int[][] arr;
  static double min;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int n = sc.nextInt();
      target = n / 2; // 벡터 매칭에 사용될 값. 점의 절반 개수
      arr = new int[n][2];
      totalX = 0;
      totalY = 0;
      min = Double.POSITIVE_INFINITY;
      // 좌표 입력 받기
      for (int j = 0; j < n; j++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        arr[j] = new int[]{x + x, y + y}; // 원래 좌표의 2배로 저장
        totalX += x; // x 좌표의 총합
        totalY += y; // y 좌표의 총합
      }

      // 시작 인덱스부터 target 이상인 경우에만 탐색 진행
      for (int j = 0; arr.length - j >= target; j++) {
        vx = totalX; // 벡터 x의 합 초기화
        vy = totalY; // 벡터 y의 합 초기화
        vectorCheck(j, 1); // 최소 벡터 합 계산
      }

      // 최소 벡터 합의 제곱근 출력
      System.out.println(Math.sqrt(min));
    }
  }

  // 최소 벡터 합 계산
  private static void vectorCheck(int idx, int depth) {
    vx -= arr[idx][0]; // x 좌표의 총합에서 해당 좌표의 2배만큼 뺌
    vy -= arr[idx][1]; // y 좌표의 총합에서 해당 좌표의 2배만큼 뺌

    if (depth >= target) { // target에 도달한 경우, 이전의 값과 비교하여 최소값 대입
      min = Math.min((long) vx * vx + (long) vy * vy, min);
    }
    else {  // 도달하지 못했다면, 다음 좌표 탐색
      depth++;
      for (int i = idx + 1; arr.length - i >= target - depth + 1; i++) {
        vectorCheck(i, depth);
      }
    }
    // 탐색 후 좌표 복원
    vx += arr[idx][0];
    vy += arr[idx][1];
  }
}
