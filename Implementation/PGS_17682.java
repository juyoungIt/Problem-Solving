// PGS - 17682
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/17682

import java.util.*;

class Solution {
    
    static class Part {
        int score;
        char region;
        Character option;
        int lastIndex;
        
        public Part(int score, char region, Character option, int lastIndex) {
            this.score = score;
            this.region = region;
            this.option = option;
            this.lastIndex = lastIndex;
        }
    }
    
    public int solution(String dartResult) {
        List<Part> parts = new LinkedList<>();
        int curIndex = 0;
        while (curIndex < dartResult.length()) {
            Part part = extract(dartResult, curIndex);
            parts.add(part);
            curIndex = part.lastIndex;
        }
        int[] scores = new int[parts.size()];
        for (int i=0; i<parts.size(); i++) {
            Part part = parts.get(i);
            int score = part.score;
            if (part.region == 'D') {
                score = (int) Math.pow(score, 2);
            } else if (part.region == 'T') {
                score = (int) Math.pow(score, 3);
            }
            if (part.option != null && part.option.equals('*')) {
                score *= 2;
                if (i > 0) {
                    scores[i - 1] *= 2;
                }
            } else if (part.option != null && part.option.equals('#')) {
                score *= -1;
            }
            scores[i] = score;
        }
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }
        return totalScore;
    }
    
    private Part extract(String dartResult, int startIndex) {
        String value = "";
        Part part = new Part(0, ' ', null, startIndex);
        int i;
        for (i=startIndex; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c == 'S' || c == 'D' || c == 'T') {
                part.score = Integer.parseInt(value);
                part.region = c;
            } else if (c == '*' || c == '#') {
                part.option = c;
            } else {
                if (part.region == 'S' || part.region == 'D' || part.region == 'T') {
                    break;
                }
                value += c;
            }
        }
        part.lastIndex = i;
        return part;
    }
}
