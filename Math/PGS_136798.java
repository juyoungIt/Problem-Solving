// PGS - 136798
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/136798

class Solution {
    public int solution(int number, int limit, int power) {
        int[] divisorCounts = new int[number + 1];
        for (int i=1; i<=number; i++) {
            for (int j=i; j<=number; j+=i) {
                divisorCounts[j]++;
            }
        }
        int answer = 0;
        for (int divisorCount : divisorCounts) {
            answer += divisorCount <= limit ? divisorCount : power;
        }
        return answer;
    }
}
