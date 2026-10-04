// PGS - 120923
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120923

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        answer[0] = ((total - num * (num - 1) / 2) / num);
        for (int i=1; i<num; i++) {
            answer[i] = answer[i - 1] + 1;
        }
        return answer;
    }
}
