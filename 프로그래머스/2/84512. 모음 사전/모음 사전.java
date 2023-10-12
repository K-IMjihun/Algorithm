import java.util.*;

class Solution {
    static List<String> list;
    static String [] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);
        
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static void dfs(String str, int len) {
        list.add(str);
        
        // 재귀호출이므로 return 시 이전 호출인 dfs("AAAA", 4)로 돌아가서 다음 알파벳을 시도
        if (len == 5) return; 
        for (int i = 0; i < 5; i++) {   // 5(알파벳 O)까지만 진행
            dfs(str + words[i], len + 1);
        }
    }
}