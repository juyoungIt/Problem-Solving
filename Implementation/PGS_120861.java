// PGS - 120861
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120861

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int[] xBoundary = new int[2];
        int[] yBoundary = new int[2];
        xBoundary[0] = -(board[0] / 2);
        xBoundary[1] = board[0] / 2;
        yBoundary[0] = -(board[1] / 2);
        yBoundary[1] = board[1] / 2;
        for (String input : keyinput) {
            switch (input) {
                case "left":
                    answer[0] = Math.max(answer[0] - 1, xBoundary[0]);
                    break;
                case "right":
                    answer[0] = Math.min(answer[0] + 1, xBoundary[1]);
                    break;
                case "up":
                    answer[1] = Math.min(answer[1] + 1, yBoundary[1]);
                    break;
                case "down":
                    answer[1] = Math.max(answer[1] - 1, yBoundary[0]);
                    break;
                default:
                    throw new IllegalArgumentException("invalid arguments...");
            }
        }
        return answer;
    }
}
