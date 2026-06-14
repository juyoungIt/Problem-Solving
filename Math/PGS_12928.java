// PGS - 12928
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12928

class Solution {
    public int solution(int n) {
        int sum = 0;
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
