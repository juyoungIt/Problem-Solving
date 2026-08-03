// PGS - 120849
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120849

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
            .filter(c -> !isVowel(c.charAt(0)))
            .collect(Collectors.joining());
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
