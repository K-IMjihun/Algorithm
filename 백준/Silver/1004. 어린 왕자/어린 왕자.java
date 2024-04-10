import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();

    for (int t = 0; t < T; t++) {
      int x1 = scanner.nextInt();
      int y1 = scanner.nextInt();
      int x2 = scanner.nextInt();
      int y2 = scanner.nextInt();
      int n = scanner.nextInt();

      int count = 0; // 진입/이탈 횟수

      for (int i = 0; i < n; i++) {
        int cx = scanner.nextInt();
        int cy = scanner.nextInt();
        int r = scanner.nextInt();

        // 출발점과 도착점이 행성계 내부에 있는 경우 아무동작도 하지 않음.
        if (isInside(x1, y1, cx, cy, r) && isInside(x2, y2, cx, cy, r));

        // 출발점 또는 도착점이 행성계 내부에 있는 경우 count 증가
        else if (isInside(x1, y1, cx, cy, r) || isInside(x2, y2, cx, cy, r))
          count++;
      }

      System.out.println(count);
    }
  }

  // 점 (x, y)가 원(cx, cy) 내부에 있는지 여부를 확인하는 함수
  private static boolean isInside(int x, int y, int cx, int cy, int r) {
    return Math.pow(x - cx, 2) + Math.pow(y - cy, 2) <= Math.pow(r, 2);
  }
}
