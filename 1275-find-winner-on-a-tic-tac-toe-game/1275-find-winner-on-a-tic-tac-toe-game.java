class Solution {
    public String tictactoe(int[][] moves) {
        char board[][] = new char[3][3];

        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            board[r][c] = (i % 2 == 0) ? 'A' : 'B';

            if (i >= 4 && isWinner (board, r, c)) {
                return String.valueOf(board[r][c]);
            }
        }

        return (moves.length == 9) ? "Draw" : "Pending";
    }

    boolean isWinner (char board[][], int r, int c) {
        if (board[r][0] == board[r][1] && board[r][1] == board[r][2]) return true;
        if (board[0][c] == board[1][c] && board[1][c] == board[2][c]) return true;
        if (r == c && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (r + c == 2 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna