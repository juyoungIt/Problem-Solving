// PGS - 120838
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120838

import java.util.*;

class Solution {
    public String solution(String letter) {
        Map<String, Character> charMap = new HashMap<>();
        charMap.put(".-", 'a'); charMap.put("-...", 'b'); charMap.put("-.-.", 'c');
        charMap.put("-..", 'd'); charMap.put(".", 'e'); charMap.put("..-.", 'f');
        charMap.put("--.", 'g'); charMap.put("....", 'h'); charMap.put("..", 'i');
        charMap.put(".---", 'j'); charMap.put("-.-", 'k'); charMap.put(".-..", 'l');
        charMap.put("--", 'm'); charMap.put("-.", 'n'); charMap.put("---", 'o');
        charMap.put(".--.", 'p'); charMap.put("--.-", 'q'); charMap.put(".-.", 'r');
        charMap.put("...", 's'); charMap.put("-", 't'); charMap.put("..-", 'u');
        charMap.put("...-", 'v'); charMap.put(".--", 'w'); charMap.put("-..-", 'x');
        charMap.put("-.--", 'y'); charMap.put("--..", 'z');
        StringBuilder sb = new StringBuilder();
        for (String token : letter.split(" ")) {
            sb.append(charMap.get(token));
        }
        return sb.toString();
    }
}
