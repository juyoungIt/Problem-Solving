// PGS - 120902
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120902

class Solution {
    public int solution(String my_string) {
        String[] expr = my_string.split(" ");
        if (expr[1].equals("+")) {
            return Integer.parseInt(expr[0]) + Integer.parseInt(expr[2]);
        } else {
            return Integer.parseInt(expr[0]) - Integer.parseInt(expr[2]);
        }
    }
}
