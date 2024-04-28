
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long answer = 0;
    String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    long[] values = {0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L};
    long[] multipliers = {1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L};
    for(int i = 0; i < 3; i++){
      String str = sc.next();
      for(int j = 0; j < colors.length; j++){
          if (colors[j].equals(str)) {
            if(i == 0) answer = values[j] * 10;
            else if(i == 1)  answer += values[j];
            else if(i == 2) answer *= multipliers[j];
          }
      }
    }
    System.out.println(answer);
  }
}