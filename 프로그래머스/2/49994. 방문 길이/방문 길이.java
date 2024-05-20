import java.util.HashSet;

public class Solution {
    public int solution(String dirs) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // U, D, R, L

        HashSet<String> visited = new HashSet<>();
        int[] charCoordinate = {0, 0};
        int answer = 0;

        for (char dir : dirs.toCharArray()) {
            int idx;
            switch (dir) {
                case 'U':
                    idx = 0;
                    break;
                case 'D':
                    idx = 1;
                    break;
                case 'R':
                    idx = 2;
                    break;
                case 'L':
                    idx = 3;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction");
            }

            int newX = charCoordinate[0] + directions[idx][0];
            int newY = charCoordinate[1] + directions[idx][1];

            // 좌표의 유효성을 체크하여 범위를 벗어나지 않도록 처리
            if (newX >= -5 && newX <= 5 && newY >= -5 && newY <= 5) {
                String path1 = charCoordinate[0] + "" + charCoordinate[1] + "" + newX + "" + newY;
                String path2 = newX + "" + newY + "" + charCoordinate[0] + "" + charCoordinate[1];
                if (!visited.contains(path1) && !visited.contains(path2)) {
                    visited.add(path1);
                    visited.add(path2);
                    answer++;
                }
                charCoordinate[0] = newX;
                charCoordinate[1] = newY;
            }
        }

        return answer;
    }
}
