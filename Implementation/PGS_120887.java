// PGS - 120887
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120887

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        char target = Integer.toString(k).charAt(0);
        for (int x=i; x<=j; x++) {
            String str = Integer.toString(x);
            for (int y=0; y<str.length(); y++) {
                char c = str.charAt(y);
                if (c == target) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
