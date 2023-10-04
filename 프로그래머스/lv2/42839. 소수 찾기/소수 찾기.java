import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        a("", numbers, set);

        int answer = 0;

        for(int num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public void a(String prefix, String str, Set<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++)
            a(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}