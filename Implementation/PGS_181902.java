// PGS - 181902
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181902

class Solution {
    public int[] solution(String my_string) {
        int[] upperCaseCount = new int[26];
        int[] lowerCaseCount = new int[26];
        for (int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCaseCount[c - 'A']++;
            } else {
                lowerCaseCount[c - 'a']++;
            }
        }
        int[] answer = new int[52];
        System.arraycopy(upperCaseCount, 0, answer, 0, 26);
        System.arraycopy(lowerCaseCount, 0, answer, 26, 26);
        return answer;
    }
}
