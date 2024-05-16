import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                cache.remove(city);
                cache.addFirst(city);
                answer += 1;
            } else {
                cache.addFirst(city);
                answer += 5;
                if (cache.size() > cacheSize) {
                    cache.removeLast();
                }
            }
        }

        return answer;
    }
}