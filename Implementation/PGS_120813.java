// PGS - 120813
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120813

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n % 2 == 0 ? n / 2 : n / 2 + 1];
        int index = 0;
        for (int i=1; i<=n; i++) {
            if (i % 2 == 0) continue;
            answer[index++] = i;
        }
        return answer;
    }
}
