// PGS - 67256
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/67256

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Character, Integer> xIndexMap = new HashMap<>();
        xIndexMap.put('1', 0); xIndexMap.put('4', 0); xIndexMap.put('7', 0); xIndexMap.put('*', 0);
        xIndexMap.put('2', 1); xIndexMap.put('5', 1); xIndexMap.put('8', 1); xIndexMap.put('0', 1);
        xIndexMap.put('3', 2); xIndexMap.put('6', 2); xIndexMap.put('9', 2); xIndexMap.put('#', 2);
        Map<Character, Integer> yIndexMap = new HashMap<>();
        yIndexMap.put('1', 0); yIndexMap.put('4', 1); yIndexMap.put('7', 2); yIndexMap.put('*', 3);
        yIndexMap.put('2', 0); yIndexMap.put('5', 1); yIndexMap.put('8', 2); yIndexMap.put('0', 3);
        yIndexMap.put('3', 0); yIndexMap.put('6', 1); yIndexMap.put('9', 2); yIndexMap.put('#', 3);
        int curLeftX = xIndexMap.get('*'), curLeftY = yIndexMap.get('*');
        int curRightX = xIndexMap.get('#'), curRightY = yIndexMap.get('#');
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                curLeftX = xIndexMap.get((char) (number + '0'));
                curLeftY = yIndexMap.get((char) (number + '0'));
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                curRightX = xIndexMap.get((char) (number + '0'));
                curRightY = yIndexMap.get((char) (number + '0'));
            } else {
                int targetX = xIndexMap.get((char) (number + '0'));
                int targetY = yIndexMap.get((char) (number + '0'));
                int leftDist = getDist(curLeftX, curLeftY, targetX, targetY);
                int rightDist = getDist(curRightX, curRightY, targetX, targetY);
                if (leftDist == rightDist) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        curLeftX = xIndexMap.get((char) (number + '0'));
                        curLeftY = yIndexMap.get((char) (number + '0'));
                    } else {
                        sb.append("R");
                        curRightX = xIndexMap.get((char) (number + '0'));
                        curRightY = yIndexMap.get((char) (number + '0'));
                    }
                } else {
                    if (leftDist < rightDist) {
                        sb.append("L");
                        curLeftX = xIndexMap.get((char) (number + '0'));
                        curLeftY = yIndexMap.get((char) (number + '0'));
                    } else {
                        sb.append("R");
                        curRightX = xIndexMap.get((char) (number + '0'));
                        curRightY = yIndexMap.get((char) (number + '0'));
                    }
                }
            }
        }
        return sb.toString();
    }
    
    private int getDist(int startX, int startY, int targetX, int targetY) {
        int[] xi = {-1, 1, 0, 0};
        int[] yi = {0, 0, -1, 1};
        boolean[][] visited = new boolean[4][3];
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();
        queueX.add(startX);
        queueY.add(startY);
        queueD.add(0);
        visited[startY][startX] = true;
        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int curX = queueX.peek();
            int curY = queueY.peek();
            int curD = queueD.peek();
            if (curX == targetX && curY == targetY) {
                return curD;
            }
            for (int i=0; i<4; i++) {
                int newX = curX + xi[i];
                int newY = curY + yi[i];
                if (!isValid(newX, newY) || visited[newY][newX]) continue;
                queueX.add(newX);
                queueY.add(newY);
                queueD.add(curD + 1);
                visited[newY][newX] = true;
            }
            queueX.poll();
            queueY.poll();
            queueD.poll();
        }
        return -1;
    }
    
    
    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<3 && y<4;
    }
}
