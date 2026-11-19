// PGS - 181832
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181832

class Solution {
    
    private static int[] xi = { 1, 0, -1, 0 };
    private static int[] yi = { 0, 1, 0, -1 };
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int dir = 0;
        int curValue = 1;
        int curX = 0, curY = 0;
        while (curValue <= n * n) {
            if (answer[curY][curX] == 0) {
                answer[curY][curX] = curValue++;
            }
            int nextX = curX + xi[dir];
            int nextY = curY + yi[dir];
            if (!isValid(answer, nextX, nextY, n)) {
                dir = (dir + 1) % 4;
                nextX = curX + xi[dir];
                nextY = curY + yi[dir];
            }
            curX = nextX;
            curY = nextY;
        }
        return answer;
    }
    
    private boolean isValid(int[][] arr, int x, int y, int n) {
        return (0 <= x && x < n)
            && (0 <= y && y < n)
            && (arr[y][x] == 0);
    }
}
