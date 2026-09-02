// PGS - 120834
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120834

import java.util.*;

class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        while (age > 0) {
            sb.append((char) ('a' + (age % 10)));
            age /= 10;
        }
        return sb.reverse().toString();
    }
}
