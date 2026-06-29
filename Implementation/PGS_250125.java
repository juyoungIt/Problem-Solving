// PGS - 250125
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/250125

class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] xi = { -1, 1, 0, 0 };
        int[] yi = { 0, 0, -1, 1 };
        int n = board.length;
        int answer = 0;
        for (int i=0; i<4; i++) {
            int newX = w + xi[i];
            int newY = h + yi[i];
            if (!isValid(newX, newY, n)) continue;
            if (board[h][w].equals(board[newY][newX])) answer++;
        }
        return answer;
    }
    
    private boolean isValid(int w, int h, int n) {
        return 0 <= w && 0 <= h && w < n && h < n;
    }
}
