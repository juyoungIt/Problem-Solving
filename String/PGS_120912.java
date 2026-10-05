// PGS - 120912
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120912

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int e : array) {
            answer += getSevenCount(e);
        }
        return answer;
    }
    
    private int getSevenCount(int n) {
        int count = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 7) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
