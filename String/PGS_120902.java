// PGS - 120902
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120902

class Solution {
    public int solution(String my_string) {
        String[] expr = my_string.split(" ");
        int result = Integer.parseInt(expr[0]);
        for (int i=1; i<expr.length; i+=2) {
            int num = Integer.parseInt(expr[i + 1]);
            if (expr[i].equals("+")) {
                result += num;
            } else {
                result -= num;
            }
        }
        return result;
    }
}
