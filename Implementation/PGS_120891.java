// PGS - 120891
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120891

class Solution {
    public int solution(int order) {
        int answer = 0;
        while (order > 0) {
            int remainder = order % 10;
            if (remainder == 3 || remainder == 6 || remainder == 9) {
                answer++;
            }
            order /= 10;
        }
        return answer;
    }
}
