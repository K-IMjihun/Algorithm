import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 좌표 수
    int[] arr = new int[N];
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for(int i = 0; i < N; i++){
      arr[i] = sc.nextInt();
    }
    int sortArr[] = arr.clone();
    Arrays.sort(sortArr);
    int count = 0;
    for(int i = 0 ; i < sortArr.length ; i++) {
      if(!hashMap.containsKey(sortArr[i])) {
        hashMap.put(sortArr[i], count++);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int n : arr)
      sb.append(hashMap.get(n)).append(' ');

    System.out.println(sb.toString());
  }
}
