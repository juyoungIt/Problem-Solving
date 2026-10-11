// PGS - 120824
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120824

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for (int num : num_list) {
            answer[num % 2 == 0 ? 0 : 1]++;
        }
        return answer;
    }
}
