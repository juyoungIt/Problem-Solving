// PGS - 12903
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12903

class Solution {
    public String solution(String s) {
        int len = s.length();
        int targetIndex = len / 2;
        if (len % 2 == 0) {
            return s.substring(targetIndex - 1, targetIndex + 1);
        } else {
            return s.substring(targetIndex, targetIndex + 1);
        }
    }
}
