import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        String answer = "";
        
        StringBuilder answerCheck = new StringBuilder();
        
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // x 숫자값 카운트
        for(int i = 0; i < X.length(); i++){
            int numberX = X.charAt(i) - 48;
            countX[numberX]++; 
        }
        
        // y 숫자값 카운트
        for(int i = 0; i < Y.length(); i++){
            int numberY = Y.charAt(i) - 48;
            countY[numberY]++;
        }
        
        // 최종값 추가
        for(int i = 9; i >= 0; i--){
            int minNumber = Math.min(countX[i], countY[i]);
            for(int j = 0; j < minNumber; j++){
                    answerCheck.append(i);
            }
        }
        
        // 최종결과값 검증
        String answerStr = answerCheck.toString();
        if (answerStr.length() == 0) {
            answer = "-1"; // 공통 숫자 없음
        } else if (answerStr.charAt(0) == '0') {
            answer = "0";  // 0으로만 이루어진 경우
        } else {
            answer = answerStr; // 일반 경우
        }
        
        return answer;
    }
}