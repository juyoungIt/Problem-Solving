// PGS - 120871
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120871

class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            answer++;
            if (!isValid(answer)) {
                continue;
            }
            n--;
        }
        return answer;
    }
    
    private boolean isValid(int n) {
        if (n % 3 == 0) return false;
        while (n > 0) {
            if (n % 10 == 3) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
