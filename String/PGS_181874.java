// PGS - 181874
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181874

import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        return myString.toLowerCase()
            .chars()
            .mapToObj(c -> c == 'a' ? "A" : String.valueOf((char) c))
            .collect(Collectors.joining());
    }
}
