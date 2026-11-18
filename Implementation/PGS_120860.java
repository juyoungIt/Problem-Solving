// PGS - 120860
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120860

import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (e1, e2) -> e1[0] - e2[0]);
        int height = Math.abs(dots[0][1] - dots[1][1]);
        int width = Math.abs(dots[1][0] - dots[2][0]);
        return width * height;
    }
}
