import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    List<String> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for(int i = 0; i < N; i++){
      set.add(sc.next());
    }
    for(int i = 0; i < M; i++){
      String name = sc.next();
      if(set.contains(name)){
        list.add(name);
      }
    }
    Collections.sort(list);

    System.out.println(list.size());
    for(String name : list){
      System.out.println(name);
    }
  }
}