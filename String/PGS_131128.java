// PGS - 131128
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/131128

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        for (int i=0; i<X.length(); i++) {
            countX[X.charAt(i) - '0']++;
        }
        for (int i=0; i<Y.length(); i++) {
            countY[Y.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=9; i>=0; i--) {
            sb.append(Integer.toString(i).repeat(Math.min(countX[i], countY[i])));
        }
        String answer = sb.toString();
        if (answer.length() == 0) return "-1";
        else if (answer.charAt(0) == '0') return "0";
        else return answer;
    }
}
