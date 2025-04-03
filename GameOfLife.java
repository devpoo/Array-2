package week3;

/*
LC: https://leetcode.com/problems/game-of-life/
TC: 2 * O(m*n)
SC: O(1)
*/
public class GameOfLife {

    // 1 -> 0 then 1 = 2
    // 0 -> 1 then 0 = 3

    // 1 dies when < 2, > 3
    // 0 lives when 3

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ;  j < n ; j++) {
                int cnt = getCount(board, i, j);
                if(board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 3;
                } else if(board[i][j] == 1 && (cnt < 2 || cnt > 3)) {
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ;  j < n ; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                } else if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getCount(int[][] board, int i, int j) {
        int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};
        int m = board.length;
        int n = board[0].length;
        int count = 0 ;
        for(int[] dir : directions) {
            int r = dir[0];
            int c = dir[1];
            if(r>=0 && r<m && c>=0 && c<n) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
