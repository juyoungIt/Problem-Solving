// PGS - 181922
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181922

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int len = arr.length;
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            for (int i=s; i<=Math.min(e, len); i++) {
                if (i % k == 0) {
                    arr[i]++;
                }
            }
        }
        return arr;
    }
}
