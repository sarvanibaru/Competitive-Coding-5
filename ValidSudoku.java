// Time Complexity : O(n^2) -> n= 9 => O(1) constant
// Space Complexity : O(1) given its fixed board size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Have 3 arrays to keep track of row, column and individual sub box validation checks. Traverse through the
entire matrix and if we find an empty cell, we just continue. Later, we need to identify which 3*3 box it is
so we compute the box index. Then, convert the character(cell value) to index value and check if we already
visited that cell value along with row or column or sub box. If so, return false, if not, mark it as true or
visited.
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                if(board[i][j] == '.')
                    continue;
                int boxIndex = (i / 3) * 3 + (j /3);
                int num = board[i][j] - '1';
                if(rows[i][num] || cols[num][j] || boxes[boxIndex][num])
                    return false;
                rows[i][num] = cols[num][j] = boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}