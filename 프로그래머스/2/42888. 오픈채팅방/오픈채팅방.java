import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // 최종 이름 저장할 Map
        Map<String, String> map = new HashMap<>();
        
        for(String rec : record){
            String[] sliceRecord = rec.split(" ");
            
            // enter와 change 일 경우에만 이름 변경
            if(sliceRecord[0].equals("Enter") || sliceRecord[0].equals("Change")){
                map.put(sliceRecord[1], sliceRecord[2]);
            }
            
        }
        
        // 출력값 저장
        List<String> answer = new ArrayList<>();
        for(String rec : record){
             String[] sliceRecord = rec.split(" ");
            
            // enter와 leave 일 경우에만 출력
            if(sliceRecord[0].equals("Enter")){
                answer.add(map.get(sliceRecord[1]) + "님이 들어왔습니다.");
                
            } else if(sliceRecord[0].equals("Leave")){
                answer.add(map.get(sliceRecord[1]) + "님이 나갔습니다.");
            }
            
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}