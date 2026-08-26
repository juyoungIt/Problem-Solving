// PGS - 181924
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181924

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            swap(arr, query[0], query[1]);
        }
        return arr;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
