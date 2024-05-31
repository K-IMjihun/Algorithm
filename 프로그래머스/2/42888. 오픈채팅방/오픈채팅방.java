import java.util.*;

public class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userNicknames = new HashMap<>();
        List<String[]> events = new ArrayList<>();

        for (String entry : record) {
            String[] parts = entry.split(" ");
            String command = parts[0];
            String userId = parts[1];

            if (command.equals("Enter")) {
                String nickname = parts[2];
                userNicknames.put(userId, nickname);
                events.add(new String[]{userId, "님이 들어왔습니다."});
            } else if (command.equals("Leave")) {
                events.add(new String[]{userId, "님이 나갔습니다."});
            } else if (command.equals("Change")) {
                String nickname = parts[2];
                userNicknames.put(userId, nickname);
            }
        }

        String[] result = new String[events.size()];
        int i = 0;
        for (String[] event : events) {
            String userId = event[0];
            String message = event[1];
            String finalMessage = userNicknames.get(userId) + message;
            result[i++] = finalMessage;
        }

        return result;
    }
}