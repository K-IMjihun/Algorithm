import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    String first = sc.next();
    int answer = 0;

    for (int i = 0; i < N - 1; i++) {
      String str = sc.next();
      int count = 0;   
      int[] word = new int[26];
      for (int j = 0; j < first.length(); j++) {
        word[first.charAt(j) - 'A']++;
      }

      for (int j = 0; j < str.length(); j++) {
        if (word[str.charAt(j) - 'A'] > 0) {
          count++;
          word[str.charAt(j) - 'A']--;
        }
      }

      // 길이가 같은 경우
      if (first.length() == str.length() && (first.length() == count || first.length() - 1 == count)) {
        answer++;
      }
      // 한글자 추가시 같은 경우
      else if (first.length() == str.length() - 1 && str.length() - 1 == count) {
        answer++;
      }
      // 한글자 제거시 같은 경우
      else if (first.length() == str.length() + 1 && str.length() == count) {
        answer++;
      }

    }
    System.out.println(answer);
    sc.close();
  }
}
