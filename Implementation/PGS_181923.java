// PGS - 181923
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181923

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int len = queries.length;
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            answer[i] = search(arr, s, e, k);
        }
        return answer;
    }
    
    private int search(int[] arr, int s, int e, int k) {
        int target = 1_000_001;
        for (int i=s; i<=e; i++) {
            if (arr[i] > k) {
                target = Math.min(target, arr[i]);
            }
        }
        return target == 1_000_001 ? -1 : target;
    }
}
