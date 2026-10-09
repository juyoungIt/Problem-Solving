// PGS - 181851
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181851

import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] result = new int[3];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<rank.length; i++) {
            indexMap.put(rank[i], i);
        }
        int curIndex = 0;
        for (int i=1; i<=rank.length; i++) {
            if (curIndex > 2) break;
            int index = indexMap.get(i);
            if (!attendance[index]) continue;
            result[curIndex++] = index;
        }
        return 10_000 * result[0] + 100 * result[1] + result[2];
    }
}
