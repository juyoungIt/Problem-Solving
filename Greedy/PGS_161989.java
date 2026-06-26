// PGS - 161989
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/161989

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0, lastPainted = 0;
        for (int s : section) {
            if (s <= lastPainted) continue;
            lastPainted = s + m - 1;
            answer++;
        }
        return answer;
    }
}
