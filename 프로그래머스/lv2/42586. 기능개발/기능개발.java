import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int progressesCount = progresses[i];
            int count = 0;
            while(progressesCount < 100){
                progressesCount += speeds[i];
                count++;
            }
            q.add(count);
            System.out.println(count);
        }
        
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int a = q.poll();
        
        while(0 < q.size()){
            if(a >= q.peek()){
                q.poll();
                count++;
                if(q.isEmpty()){
                    list.add(count);
                }
            }
            
            else{
                list.add(count);
                count = 1;
                a = q.poll();
                if(q.isEmpty()){
                    list.add(count);
                }   
                continue;
            }


        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}