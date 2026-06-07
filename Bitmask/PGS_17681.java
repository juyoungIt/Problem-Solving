// PGS - 17681
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/17681

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            String row = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = "0".repeat(Math.max(0, n - row.length())) + row;
            answer[i] = answer[i].replace("1", "#").replace("0", " ");
        }
        return answer;
    }
}
