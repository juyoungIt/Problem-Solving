// PGS - 12934
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12934

class Solution {
    public long solution(long n) {
        double x = Math.sqrt(n);
        if (((long) x) == x) return (long) Math.pow(x + 1, 2);
        else return -1;
    }
}
