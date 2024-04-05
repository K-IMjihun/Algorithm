import java.util.*;

public class Main{

  public static void main(String [] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int student[] = new int [N];
    Queue<Integer> queue = new LinkedList<>();
    for(int i=0;i<N;i++) {
//      student[i] = sc.nextInt();
      queue.add(sc.nextInt());
    }
    int min = 1;
    Stack<Integer>stack = new Stack<>();
    while (!queue.isEmpty()){
      int currentNumber = queue.peek();
      if(currentNumber != min){
        if(!stack.isEmpty() && stack.peek() == min){
          stack.pop();
          min++;
        }
        else {
          stack.push(queue.poll());
        }
      }
      else {
        queue.poll();
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