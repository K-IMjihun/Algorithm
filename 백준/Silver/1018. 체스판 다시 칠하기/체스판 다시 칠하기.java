import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String[] board = new String[a];
        for (int i=0; i<a; i++) {
            String str = sc.next();
            board[i] = str;
        }
        int answer = Integer.MAX_VALUE;
        // a=10, b=10
        // 시작점: 0,0 0,1 0,2,
        //        1,0 1,1 1,2
        //        2,0 2,1 2,2
        for (int i = 0; i < a-7; i++){
            for(int j = 0; j < b-7; j++){
                int countB = 0, countW = 0;
                for (int k = i; k < i+8; k++) {
                    for(int l = j; l < j+8; l++){
                        if((k+l) % 2 == 0){ // 짝수
                            if(board[k].charAt(l) != 'B'){
                                countB++;
                            }
                            if(board[k].charAt(l) != 'W'){
                                countW++;
                            }
                        } else {
                            if(board[k].charAt(l) != 'B'){
                                countW++;
                            }
                            if(board[k].charAt(l) != 'W'){
                                countB++;
                            }
                        }
                    }
                }
                answer = Math.min(answer, Math.min(countW, countB));
            }
        }
        System.out.println(answer);
    }
}