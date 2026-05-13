// PGS - 42840
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = { 1, 2, 3, 4, 5 };
        int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] scores = new int[3];
        for (int i=0 ; i<answers.length; i++) {
            int answer = answers[i];
            if (pattern1[i % pattern1.length] == answer) scores[0]++;
            if (pattern2[i % pattern2.length] == answer) scores[1]++;
            if (pattern3[i % pattern3.length] == answer) scores[2]++;
        }
        int maxScore = 0;
        for (int score : scores) maxScore = Math.max(maxScore, score);
        List<Integer> topScorer = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if (scores[i] == maxScore) {
                topScorer.add(i + 1);
            }
        }
        int[] answer = new int[topScorer.size()];
        for (int i=0; i<topScorer.size(); i++) {
            answer[i] = topScorer.get(i);
        }
        return answer;
    }
}
