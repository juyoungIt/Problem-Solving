// PGS - 181846
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181846

import java.math.*;

class Solution {
    public String solution(String a, String b) {
        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);
        return bigA.add(bigB).toString();
    }
}
