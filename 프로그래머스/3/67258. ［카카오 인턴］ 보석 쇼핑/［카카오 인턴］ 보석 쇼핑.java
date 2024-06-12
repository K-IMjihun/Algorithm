import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemCount = new HashMap<>();
        Queue<String> gemQueue = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        int start = 0;

        for (String gem : gems) {
            gemCount.put(gem, gemCount.getOrDefault(gem, 0) + 1);
            gemQueue.offer(gem);

            while (true) {
                String firstGem = gemQueue.peek();
                if (gemCount.get(firstGem) > 1) {
                    gemCount.put(firstGem, gemCount.get(firstGem) - 1);
                    gemQueue.poll();
                    start++;
                } else {
                    break;
                }
            }

            if (gemCount.size() == gemSet.size() && gemQueue.size() < minLength) {
                minLength = gemQueue.size();
                answer[0] = start + 1;
                answer[1] = start + minLength;
            }
        }

        return answer;
    }
}
