// PGS - 12931
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12931

public class Solution {
    public int solution(int n) {
        int sum = 0;
        while (n / 10 > 0) {
            sum += n % 10;
            n /= 10;
        }
        sum += n % 10;
        return sum;
    }
}
