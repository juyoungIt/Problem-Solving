// PGS - 120911
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120911

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
            .map(String::toLowerCase)
            .sorted()
            .collect(Collectors.joining());
    }
}
