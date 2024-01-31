import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> a = new HashMap<String, Integer>();
        for (int i = 0; i < name.length; i++) {
            a.put(name[i], yearning[i]);
        }
        for (String key : a.keySet()) {
            System.out.println("Key: " + key + ", Value: " + a.get(key));
        }
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (a.containsKey(photo[i][j])) {
                    answer[i] += a.get(photo[i][j]);
                }
            }
        }
        return answer;
    }
}