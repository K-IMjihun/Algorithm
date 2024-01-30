import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
 		Map<Integer, String> rank = new HashMap<>();
        Map<String, Integer> player = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rank.put(i + 1, players[i]);    
            player.put(players[i], i + 1);  
        }

        for (String calling : callings) {
            int backRank = player.get(calling);        
            int frontRank = backRank - 1;
            String frontPlayer = rank.get(frontRank);

            rank.put(frontRank, calling);
            rank.put(backRank, frontPlayer);
            player.put(frontPlayer, backRank);
            player.put(calling, frontRank);
        }

        String[] answer = new String[players.length];
        int cnt = 0;
        for(String value : rank.values()){
            answer[cnt++] = value;
        }
        return answer;
    }
}