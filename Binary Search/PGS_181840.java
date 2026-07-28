// PGS - 181840
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181840

import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        Arrays.sort(num_list);
        int left = 0, right = num_list.length - 1;
        int optIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num_list[mid] == n) {
                optIndex = mid;
                break;
            } else if (num_list[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return optIndex < 0 ? 0 : 1;
    }
}
