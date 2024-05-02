class Solution {
    public int solution(String[] board) {
        int[] count = getCount(board);
        boolean o = false;
        boolean x = false;

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("OOO")) {
                o = true;
            } else if (board[i].equals("XXX")) {
                x = true;
            }

            if (board[0].charAt(i) == board[1].charAt(i) &&
                board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'O') {
                    o = true;
                } else if (board[0].charAt(i) == 'X') {
                    x = true;
                }
            }
        }

        // Check diagonals
        if ((board[0].charAt(0) == board[1].charAt(1) &&
             board[1].charAt(1) == board[2].charAt(2)) ||
            (board[0].charAt(2) == board[1].charAt(1) &&
             board[1].charAt(1) == board[2].charAt(0))) {
            if (board[1].charAt(1) == 'O') {
                o = true;
            } else if (board[1].charAt(1) == 'X') {
                x = true;
            }
        }

        // Determine winner and return result
        if (count[0] == count[1]) {
            if ((!o && !x) || (x && !o)) {
                return 1;
            }
        } else if (count[0] == count[1] + 1) {
            if ((!o && !x) || (o && !x)) {
                return 1;
            }
        }

        return 0;
    }

    // Count 'O's and 'X's in the board
    private int[] getCount(String[] board) {
        int[] count = new int[2];

        for (String s : board) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'O') {
                    count[0]++;
                } else if (s.charAt(i) == 'X') {
                    count[1]++;
                }
            }
        }

        return count;
    }
}
