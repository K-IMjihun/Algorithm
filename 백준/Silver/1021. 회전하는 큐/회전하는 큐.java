import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  static Queue<Integer> findNumbers;
  static Deque<Integer> deque;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int count = 0;
    deque = new LinkedList<>();
    findNumbers = new LinkedList<>();

    // 찾아야 할 수 입력
    for (int i = 0; i < M; i++) {
      findNumbers.add(sc.nextInt());
    }

    // 초기 큐 설정
    for (int i = 1; i <= N; i++) {
      deque.add(i);
    }

    // 각 뽑아내려는 수에 대해 거리 계산
    while (!findNumbers.isEmpty()) {
      int findNumber = findNumbers.poll();
      int leftMove = 0;
      int rightMove = 0;

      // 현재 큐에서 목표하는 값의 인덱스 찾기
      int index = 0;
      for (int element : deque) {
        index++;
        if (element == findNumber) break;
      }

      // 왼쪽으로 이동할 때의 거리 계산
      leftMove = index - 1;

      // 오른쪽으로 이동할 때의 거리 계산
      rightMove = deque.size() - index + 1;

      // 왼쪽 또는 오른쪽으로 이동하는 것 중에서 최소 거리 선택
      count += Math.min(leftMove, rightMove);

      // 덱을 해당 위치로 이동
      while (deque.peek() != findNumber) {
        deque.offerLast(deque.pollFirst());
      }

      // 원소 제거
      deque.pollFirst();
    }

    System.out.println(count);
  }
}
