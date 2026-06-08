// PGS - 17682
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/17682

import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        int[] scores = new int[3];
        int index = 0;
        while (matcher.find()) {
            int score = Integer.parseInt(matcher.group(1));
            char region = matcher.group(2).charAt(0);
            switch (region) {
                case 'S': scores[index] = score; break;
                case 'D': scores[index] = (int) Math.pow(score, 2); break;
                case 'T': scores[index] = (int) Math.pow(score, 3);
            }
            if ("*".equals(matcher.group(3))) {
                scores[index] *= 2;
                if (index > 0) scores[index - 1] *= 2;
            } else if ("#".equals(matcher.group(3))) {
                scores[index] *= -1;
            }
            index++;
        }
        return scores[0] + scores[1] + scores[2];
    }
}
