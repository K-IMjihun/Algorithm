import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      String input = scanner.nextLine();
      if (input.equals(".")) {
        break;
      }
      System.out.println(check(input));
    }
  }

  private static String check(String input) {
    Stack<Character> characters = new Stack<>();
    boolean answer = true;
    char character;
    for (int i = 0; i < input.length(); i++) {
      // 괄호를 여는 부분이면 stack에 저장
      if (input.charAt(i) == '(' || input.charAt(i) == '[') {
        characters.push(input.charAt(i));
      }

      // 괄호를 닫는 부분
      else if (input.charAt(i) == ')'|| input.charAt(i) == ']') {
        // 스택이 비어있다면 실패
        if (characters.isEmpty()) {
          answer = false;
          break;
        }

        // 비어있지 않다면
        character = characters.pop();


        if(character == '('){
          if(!(input.charAt(i) == ')')){
            answer = false;
            break;
          }
        }
        else if(character == '['){
          if(!(input.charAt(i) == ']')){
            answer = false;
            break;
          }
        }
      }
    }
    if(answer && characters.isEmpty()){
      return "yes";
    }
    else{
      return "no";
    }
  }
}
