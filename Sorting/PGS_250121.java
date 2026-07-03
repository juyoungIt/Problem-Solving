// PGS - 250121
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/250121

import java.util.*;

class Solution {  
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> columnIndex = Map.of(
            "code", 0,
            "date", 1,
            "maximum", 2,
            "remain", 3
        );
        int extIndex = columnIndex.get(ext);
        int sortByIndex = columnIndex.get(sort_by);
        return Arrays.stream(data)
            .filter(d -> d[extIndex] < val_ext)
            .sorted(Comparator.comparingInt(d -> d[sortByIndex]))
            .toArray(int[][]::new);
    }
}
