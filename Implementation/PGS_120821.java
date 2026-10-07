// PGS - 120821
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120821

class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            answer[i] = num_list[len - i - 1];
        }
        return answer;
    }
}
