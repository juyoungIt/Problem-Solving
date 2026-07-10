// PGS - 181866
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181866

import java.util.*;

class Solution {
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x"))
            .filter(str -> !str.isEmpty())
            .sorted()
            .toArray(String[]::new);
    }
}
