// PGS - 118666
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/118666

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();
        scores.put('R', 0); scores.put('T', 0);
        scores.put('C', 0); scores.put('F', 0);
        scores.put('J', 0); scores.put('M', 0);
        scores.put('A', 0); scores.put('N', 0);
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int choice = choices[i];
            if (choice < 4) {
                scores.put(disagree, scores.get(disagree) + (4 - choice));
            } else if (choice > 4) {
                scores.put(agree, scores.get(agree) + (choice - 4));
            }
        }
        StringBuilder answer = new StringBuilder();
        if (scores.get('R') >= scores.get('T')) answer.append('R');
        else answer.append('T');
        if (scores.get('C') >= scores.get('F')) answer.append('C');
        else answer.append('F');
        if (scores.get('J') >= scores.get('M')) answer.append('J');
        else answer.append('M');
        if (scores.get('A') >= scores.get('N')) answer.append('A');
        else answer.append('N');
        return answer.toString();
    }
}
