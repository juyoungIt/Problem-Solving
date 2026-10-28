// PGS - 120876
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120876

class Solution {
    
    private static final int RANGE = 100;
    
    public int solution(int[][] lines) {
        int[] axis = new int[100 * 2 + 1];
        for (int[] line : lines) {
            for (int i=line[0]; i<line[1]; i++) {
                axis[i + RANGE]++;
            }
        }
        int answer = 0;
        for (int i=0; i<RANGE*2+1; i++) {
            if (axis[i] > 1) {
                answer++;
            }
        }
        return answer;
    }
}
