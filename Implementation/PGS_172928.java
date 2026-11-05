// PGS - 172928
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/172928

class Solution {
    
    private static int width, height;
    private static char[][] board;
    private static int curX, curY;
    
    public int[] solution(String[] park, String[] routes) {
        width = park[0].length();
        height = park.length;
        board = new char[height][width];
        curX = 0;
        curY = 0;
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                board[i][j] = park[i].charAt(j);
                if (board[i][j] == 'S') {
                    curX = j;
                    curY = i;
                }
            }
        }
        for (String route : routes) {
            String[] token = route.split(" ");
            char direction = token[0].charAt(0);
            int distance = Integer.parseInt(token[1]);
            if (!isValid(direction, distance)) continue;
            switch (direction) {
                case 'N':
                    curY -= distance;
                    break;
                case 'S':
                    curY += distance;
                    break;
                case 'W':
                    curX -= distance;
                    break;
                case 'E':
                    curX += distance;
                    break;
                default:
                    throw new IllegalArgumentException("invalid direction: " + direction);
            }
        }
        return new int[]{curY, curX};
    }
    
    private boolean isValid(char direction, int distance) {
        if (direction == 'N') {
            if (curY - distance < 0) return false;
            for (int i=0; i<=distance; i++) {
                if (board[curY - i][curX] == 'X') {
                    return false;
                }
            }
        } else if (direction == 'S') {
            if (curY + distance >= height) return false;
            for (int i=0; i<=distance; i++) {
                if (board[curY + i][curX] == 'X') {
                    return false;
                }
            }
        } else if (direction == 'W') {
            if (curX - distance < 0) return false;
            for (int i=0; i<=distance; i++) {
                if (board[curY][curX - i] == 'X') {
                    return false;
                }
            }
        } else if (direction == 'E') {
            if (curX + distance >= width) return false;
            for (int i=0; i<=distance; i++) {
                if (board[curY][curX + i] == 'X') {
                    return false;
                }
            }
        } else {
            throw new IllegalArgumentException("invalid direction: " + direction);
        }
        return true;
    }
}
