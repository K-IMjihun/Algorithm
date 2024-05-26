import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        int dictSize = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), dictSize++);
        }

        List<Integer> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            current.append(msg.charAt(i));

            if (!dictionary.containsKey(current.toString())) {
                // 사전에 현재 문자열을 추가하고
                dictionary.put(current.toString(), dictSize++);
                // 이전까지의 문자열의 색인 번호를 결과에 추가한다.
                result.add(dictionary.get(current.substring(0, current.length() - 1)));
                // 새로운 문자열 시작
                current = new StringBuilder(String.valueOf(msg.charAt(i)));
            }
        }
        
        // 마지막 남은 문자열의 색인 번호를 추가한다.
        if (current.length() > 0) {
            result.add(dictionary.get(current.toString()));
        }

        // List를 Array로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}