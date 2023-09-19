import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length-1; i++){
            String number = phone_book[i+1];
            if(phone_book[i].length() < number.length()){
                number = phone_book[i+1].substring(0, phone_book[i].length());
            }
            if(phone_book[i].equals(number)){
                answer = false;
                break;
            }
        }
        return answer;
    }
}