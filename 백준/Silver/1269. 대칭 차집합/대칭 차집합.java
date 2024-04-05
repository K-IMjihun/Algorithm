import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    Set<Integer> nSet = new HashSet<>();
    Set<Integer> mSet = new HashSet<>();
    int answer = 0;
    for(int i = 0; i < N; i++){
      nSet.add(sc.nextInt());
    }
    for(int i = 0; i < M; i++){
      mSet.add(sc.nextInt());
    }
    for(int number : nSet){
      if(!mSet.contains(number)) answer++;
    }
    for(int number : mSet){
      if(!nSet.contains(number)) answer++;
    }
    System.out.println(answer);
  }
}