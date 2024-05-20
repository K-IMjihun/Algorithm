import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
    long primeNumberCheck = 0;
    Stack<Long> kNumbers = new Stack<>();

  while (n > 0) {
    long remainder = n % k;
    kNumbers.push(remainder);
    n /= k;
  }
  while (!kNumbers.isEmpty()){
    long numberCheck = kNumbers.pop();
    if(numberCheck != 0){
      if(primeNumberCheck == 0){
        primeNumberCheck = numberCheck;
      }
      else {
        primeNumberCheck = (primeNumberCheck * 10) + numberCheck;
      }
    }
    else {
      if(isPrime(primeNumberCheck)) answer++;
      primeNumberCheck = 0;
    }
  }
  if(primeNumberCheck != 0 && isPrime(primeNumberCheck)) answer++;
//    System.out.println(answer);
    return answer;
  }
  public static boolean isPrime(long num) {
    if (num <= 1) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    if (num % 2 == 0) {
      return false;
    }
    for (int i = 3; i <= Math.sqrt(num); i += 2) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}