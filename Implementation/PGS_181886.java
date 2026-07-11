// PGS - 181886
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181886

class Solution {
    public String[] solution(String[] names) {
        int len = names.length;
        int curIndex = 0;
        String[] answer = new String[len / 5 + ((len % 5 > 0) ? 1 : 0)];
        int count = 0;
        while (curIndex < len) {
            answer[count++] = names[curIndex];
            curIndex += 5;
        }
        return answer;
    }
}
