// PGS - 181897
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181897

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        if (n == 1) {
            return Arrays.stream(num_list)
                .limit(b + 1)
                .toArray();
        } else if (n == 2) {
            return Arrays.stream(num_list)
                .skip(a)
                .toArray();
        } else if (n == 3) {
            return Arrays.stream(num_list)
                .skip(a)
                .limit(b - a + 1)
                .toArray();
        } else {
            return IntStream.range(a, b + 1)
                .filter(i -> (i - a) % c == 0)
                .map(i -> num_list[i])
                .toArray();
        }
    }
}
