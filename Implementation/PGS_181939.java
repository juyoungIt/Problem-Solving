// PGS - 181939
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181939

class Solution {
    public int solution(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        int ab = Integer.parseInt(strA + strB);
        int ba = Integer.parseInt(strB + strA);
        return Math.max(ab, ba);
    }
}
