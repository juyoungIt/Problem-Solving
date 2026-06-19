// PGS - 12922
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12922

class Solution {
    public String solution(int n) {
        String[] s = {"¼ö", "¹Ú"};
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(s[i % 2]);
        }
        return sb.toString();
    }
}
