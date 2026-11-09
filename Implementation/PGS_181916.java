// PGS - 181916
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181916

import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        countMap.put(b, countMap.getOrDefault(b, 0) + 1);
        countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        countMap.put(d, countMap.getOrDefault(d, 0) + 1);
        List<Integer> keys = new ArrayList<>(countMap.keySet());
        keys.sort((k1, k2) -> countMap.get(k2) - countMap.get(k1));
        int p = keys.get(0);
        switch (keys.size()) {
            case 1:
                return 1111 * p;
            case 2:
                int q = keys.get(1);
                if (countMap.get(p) == 3) return (10 * p + q) * (10 * p + q);
                return (p + q) * Math.abs(p - q);
            case 3:
                return keys.get(1) * keys.get(2);
            default:
                return Collections.min(keys);
        }
    }
}
