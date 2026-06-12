// PGS - 136798
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/136798

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            int primeCount = getPrimeCount(i);
            if (primeCount > limit) {
                answer += power;
            } else {
                answer += primeCount;
            }
        }
        return answer;
    }
    
    private int getPrimeCount(int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}
