import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String cloth = clothes[i][1];
            map.put(cloth, map.getOrDefault(cloth, 1) + 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            answer *= entry.getValue();
        }
        
        return answer - 1;
    }
}