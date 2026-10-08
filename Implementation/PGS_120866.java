// PGS - 120866
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120866

class Solution {
    
    private static final int[] xi = { -1, -1, -1, 1, 1, 1, 0, 0 };
    private static final int[] yi = { 0, -1, 1, 1, 0, -1, 1, -1 };
    
    public int solution(int[][] board) {
        int n = board.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 1) {
                    for (int k=0; k<8; k++) {
                        int curX = j + xi[k];
                        int curY = i + yi[k];
                        if (!isValid(curX, curY, n)) continue;
                        if (board[curY][curX] == 0) {
                            board[curY][curX] = 2;
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    private boolean isValid(int x, int y, int n) {
        return 0<=x && 0<=y && x<n && y<n;
    }
}
