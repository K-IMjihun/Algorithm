import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
    HashMap<Character, Integer> minPressMap = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            for (int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                // 현재 문자에 대한 최소 입력 횟수를 저장, 이미 있으면 더 작은 값으로 갱신
                minPressMap.put(c, Math.min(minPressMap.getOrDefault(c, Integer.MAX_VALUE), j + 1));
            }
        }

        // 각 문자열에 대해 최소 입력 횟수 계산
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPress = 0;

            // 입력 횟수 합산
            for (char c : target.toCharArray()) {
                if (minPressMap.containsKey(c)) {
                    totalPress += minPressMap.get(c);
                } else {
                    // 문자를 만들 수 없는 경우
                    totalPress = -1;
                    break;
                }
            }
            answer[i] = totalPress;
        }
        return answer;
    }
}