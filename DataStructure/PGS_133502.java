// PGS - 133502
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/133502

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        int answer = 0, lastIngredient = 0, size = 0;
        for (int i=0; i<ingredient.length; i++) {
            list.add(ingredient[i]);
            size = list.size();
            if (size >= 4 && list.get(size - 1) == 1) {
                if (size < 4) continue;
                if (list.get(size - 1) == 1 
                    && list.get(size - 2) == 3
                    && list.get(size - 3) == 2
                    && list.get(size - 4) == 1) {
                    for (int j=0; j<4; j++) {
                        list.remove(list.size() - 1);
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}
