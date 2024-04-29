import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < N; i++){
      int a = sc.nextInt();
      map.put(a, map.getOrDefault(a, 0) +1);
    }
    int answer = sc.nextInt();
    System.out.println(map.containsKey(answer) ? map.get(answer) : 0);
  }
}
