// PGS - 159994
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/159994

import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int n = goal.length;
        int n1 = cards1.length;
        int n2 = cards2.length;
        int idx1 = 0, idx2 = 0, curIdx = 0;
        while (idx1 < n1 && idx2 < n2) {
            if (curIdx >= n) return "Yes";
            if (cards1[idx1].equals(goal[curIdx])) {
                idx1++;
            } else if (cards2[idx2].equals(goal[curIdx])) {
                idx2++;
            } else {
                return "No";
            }
            curIdx++;
        }
        while (idx1 < n1) {
            if (curIdx >= n) return "Yes";
            if (cards1[idx1].equals(goal[curIdx])) {
                idx1++;
            } else {
                return "No";
            }
            curIdx++;
        }
        while (idx2 < n2) {
            if (curIdx >= n) return "Yes";
            if (cards2[idx2].equals(goal[curIdx])) {
                idx2++;
            } else {
                return "No";
            }
            curIdx++;
        }
        return "Yes";
    }
}
