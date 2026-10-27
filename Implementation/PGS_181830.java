// PGS - 181830
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181830

class Solution {
    public int[][] solution(int[][] arr) {
        int rowLen = arr.length;
        int colLen = arr[0].length;
        int len = Math.max(rowLen, colLen);
        int[][] answer = new int[len][len];
        for (int i=0; i<len; i++) {
            if (i < rowLen) {
                System.arraycopy(arr[i], 0, answer[i], 0, colLen);
            }
        }
        return answer;
    }
}
