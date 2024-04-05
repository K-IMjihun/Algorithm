import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      String input = br.readLine();

      if (input.contains("push")) {
        int number = Integer.parseInt(input.substring(5));
        // push 연산일 때
        deque.add(number);
      } else if (input.contentEquals("pop")) {
        sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
      } else if (input.contentEquals("size")) {
        sb.append(deque.size()).append('\n');
      } else if (input.contentEquals("empty")) {
        sb.append(deque.isEmpty() ? 1 : 0).append('\n');
      } else if (input.contentEquals("front")) {
        sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
      } else if (input.contentEquals("back")) {
        sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
      }
    }
    System.out.print(sb);
  }
}
