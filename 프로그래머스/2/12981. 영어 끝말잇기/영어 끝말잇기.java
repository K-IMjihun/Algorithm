import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int count = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            
            // 글자가 중복될 경우
            if(set.contains(words[i])){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            // 마지막 글자와 첫번째 글자가 틀릴경우
            else if(i > 0 && words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            else{
                set.add(words[i]);
            }
        }

        return answer;
    }
}