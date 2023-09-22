import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int priority : priorities) {
            q.add(priority);
        }

        List<Integer> list = new ArrayList<>();
        for (int priority : priorities) {
            list.add(priority);
        }

        list.sort(Collections.reverseOrder());

        int locationCheck = location;

        label:for (Integer integer : list) {
            for (int i = 0; i < q.size(); i++) {
                if (Objects.equals(integer, q.peek())) {
                    answer++;
                    q.poll();
                    if (locationCheck == 0) {
                        break label;
                    } else {
                        locationCheck--;
                    }
                    if(!q.contains(integer)){
                        break;
                    }

                } else {
                    q.add(q.poll());
                    if (locationCheck == 0) {
                        locationCheck = q.size() - 1;

                    } else {
                        locationCheck--;
                    }
                }
            }
        }
        return answer;
    }
}