import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sequence = new StringBuilder();
        int num = 0;

        // 게임에 필요한 숫자들을 미리 생성
        while (sequence.length() < t * m) {
            sequence.append(convertToBase(num++, n));
        }

        // 튜브의 숫자 추출
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            result.append(sequence.charAt(i * m + (p - 1)));
        }

        return result.toString();
    }
    public String convertToBase(int num, int base) {
        String chars = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();

        if (num == 0) return "0";
    
        while (num > 0) {
            result.insert(0, chars.charAt(num % base));
            num /= base;
        }

        return result.toString();
    }
}
