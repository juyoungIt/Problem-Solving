// PGS - 181837
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181837

import java.util.*;

class Solution {
    
    private static final int CAFELATTE_PRICE = 5_000;
    private static final int AMERICANO_PRICE = 4_500;
    
    public int solution(String[] order) {
        return Arrays.stream(order)
            .map(o -> o.replace("ice", "").replace("hot", ""))
            .mapToInt(o -> o.equals("cafelatte") ? CAFELATTE_PRICE : AMERICANO_PRICE)
            .sum();
    }
}
