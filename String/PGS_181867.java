// PGS - 181867
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181867

import java.util.*;

class Solution {
    public int[] solution(String myString) {
        return Arrays.stream(myString.split("x", -1))
            .mapToInt(String::length)
            .toArray();
    }
}
