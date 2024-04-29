import java.util.*;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    boolean[] arr = new boolean[30];
    for(int i = 0; i < arr.length - 2; i++){
      int number = sc.nextInt() - 1;
      arr[number] = true;
    }
    for(int i = 0; i < arr.length; i++){
      if(!arr[i]) System.out.println(i + 1);
    }
  }
}
