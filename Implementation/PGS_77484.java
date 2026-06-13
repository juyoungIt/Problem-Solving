// PGS - 77484
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/77484

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        for (int win_num : win_nums) {
            winSet.add(win_num);
        }
        int unknownCount = 0, unMatchedCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                unknownCount++;
                continue;
            }
            if (!winSet.contains(lotto)) {
                unMatchedCount++;
            }
        }
        int maxRank = getRank(6 - unMatchedCount);
        int minRank = getRank(6 - unMatchedCount - unknownCount);
        return new int[]{ maxRank, minRank };
    }
    
    private int getRank(int matchedCount) {
        switch (matchedCount) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            case 1:
            case 0: return 6;
            default: return 0;
        }
    }
}
