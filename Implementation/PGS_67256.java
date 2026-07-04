// PGS - 67256
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/67256

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int curLeftIndex = 10, curRightIndex = 12;
        for (int number : numbers) {
            if (number == 0) number = 11;
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                curLeftIndex = number;
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                curRightIndex = number;
            } else {
                int leftDist = getDist(curLeftIndex, number);
                int rightDist = getDist(curRightIndex, number);
                if (leftDist < rightDist) {
                    sb.append("L");
                    curLeftIndex = number;
                } else if (leftDist > rightDist) {
                    sb.append("R");
                    curRightIndex = number;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        curLeftIndex = number;
                    } else {
                        sb.append("R");
                        curRightIndex = number;
                    }
                }
            }
        }
        return sb.toString();
    }
    
    private int getDist(int curIndex, int targetIndex) {
        int curX = (curIndex - 1) / 3;
        int curY = (curIndex - 1) % 3;
        int targetX = (targetIndex - 1) / 3;
        int targetY = (targetIndex - 1) % 3;
        return Math.abs(curX - targetX) + Math.abs(curY - targetY);
    }
}
