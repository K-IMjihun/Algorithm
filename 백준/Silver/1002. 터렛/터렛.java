import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int i = 0; i < T; i++){
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int r1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();
      int r2 = sc.nextInt();
      System.out.println(positions(x1, y1, r1, x2, y2, r2));
    }

  }
  private static int positions(int x1, int y1, int r1, int x2, int y2, int r2) {
   int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

   // 터렛의 위치와 관측시야가 같은 경우
   if(x1 == x2 && y1 == y2 && r1 == r2) return -1;
   // 두 원의 반지름 합보다 중점간 거리가 더 길 때
   else if(Math.pow(r1 + r2, 2) < distance) return 0;
   // 원 안에 원이 있으나, 내접하지 않을 때
   else if(Math.pow(r2 - r1, 2) > distance) return 0;
   // 원 안에 원이 있고, 겹치는 좌표가 있을 경우
   else if(Math.pow(r2 - r1, 2) == distance) return 1;
   // 원 밖에 원이 있지만, 겹치는 좌표가 있을 경우
   else if(Math.pow(r1 + r2, 2) == distance) return 1;
   // 이외의 경우는 무조건 2
   return 2;
  }

}