import java.util.*;

public class Main{

  public static void main(String [] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int student[] = new int [N];
    for(int i=0;i<N;i++) {
      student[i] = sc.nextInt();
    }
    int min = 1;
    Stack<Integer>stack = new Stack<>();
    for(int i=0;i<N;i++) {
      if(student[i] != min) {
        if(!stack.isEmpty() && stack.peek() == min) {
          stack.pop();
          i--;
          min++;
        }else {
          stack.push(student[i]);
        }

      }else {
        min++;
      }
    }
    boolean answer = true;

    for(int i=0;i<stack.size();i++) {
      int stu = stack.pop();
      if(stu == min) {
        min++;
      }else {
        answer = false;
        break;
      }
    }
    String result = answer ? "Nice" : "Sad";
    System.out.println(result);

  }


}