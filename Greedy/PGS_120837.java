// PGS - 120837
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120837

class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] ap = { 5, 3, 1 };
        for (int i=0; i<ap.length; i++) {
            answer += hp / ap[i];
            hp %= ap[i];
        }
        return answer;
    }
}
