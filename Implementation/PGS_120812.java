// PGS - 120812
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120812

class Solution {
    public int solution(int[] array) {
        int[] counts = new int[1_000];
        for (int element : array) {
            counts[element]++;
        }
        int maxCount = 0, answer = -1;
        for (int i=0; i<1_000; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                answer = i;
            } else if (counts[i] == maxCount) {
                answer = -1;
            }
        }
        return answer;
    }
}
