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

    for (int i = 0; i < input.length(); i++) {
      
      char currentChar = input.charAt(i);
      // 괄호를 여는 부분이면 stack에 저장
      if (currentChar == '(' || currentChar == '[') {
        characters.push(currentChar);
      }

      // 괄호를 닫는 부분
      else if (currentChar == ')'|| currentChar == ']') {
        // 스택이 비어있다면 실패
        if (characters.isEmpty()) {
          return "no";
        }

        // 비어있지 않다면
        char character = characters.pop();

        if((character == '(' && currentChar !=')') ||
            (character == '[' && currentChar != ']')){
            return "no";
        }
      }
    }
    return characters.isEmpty() ? "yes" : "no";
  }
}
