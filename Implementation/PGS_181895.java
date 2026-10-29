// PGS - 181895
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181895

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int mergedLen = 0;
        for (int[] interval : intervals) {
            mergedLen += interval[1] - interval[0] + 1;
        }
        int[] answer = new int[mergedLen];
        int index = 0;
        for (int[] interval : intervals) {
            int len = interval[1] - interval[0] + 1;
            System.arraycopy(arr, interval[0], answer, index, len);
            index += len;
        }
        return answer;
    }
}
