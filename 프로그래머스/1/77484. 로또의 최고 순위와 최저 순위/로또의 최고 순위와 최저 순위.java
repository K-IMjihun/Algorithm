class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
       int[] answer = new int[2];
        int zeroCount = 0;
        int lottoScore = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            } else {
                for (int j = 0; j < lottos.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        lottoScore++;
                        break;
                    }
                }
            }
        }
        answer[0] = ScoreCheck((lottoScore + zeroCount));
        answer[1] = ScoreCheck(lottoScore);
        return answer;
    }
    public static int ScoreCheck(int lottoScore) {
        int answer = 0;
        switch (lottoScore) {
            case 2 :
                answer = 5;
                break;
            case 3 :
                answer = 4;
                break;
            case 4 :
                answer = 3;
                break;
            case 5 :
                answer = 2;
                break;
            case 6 :
                answer = 1;
                break;
            default: 
                answer = 6;
        }
        return answer;
    }
}