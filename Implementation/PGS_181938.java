// PGS - 181938
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181938

class Solution {
    public int solution(int a, int b) {
        int resultA = integerConcat(a, b);
        int resultB = 2 * a * b;
        return Math.max(resultA, resultB);
    }
    
    private int integerConcat(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        return Integer.parseInt(strA + strB);
    }
}
