// PGS - 133499
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/133499

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] validWords = { "aya", "ye", "woo", "ma" };
        for (String word : babbling) {
            for (String validWord : validWords) {
                if (word.contains(validWord + validWord)) continue;
                word = word.replace(validWord, " ");
            }
            if (word.trim().isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
