// PGS - 120875
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120875

class Solution {
    public int solution(int[][] dots) {
        int[][] pairs = {
            {0, 1, 2, 3},
            {0, 2, 1, 3},
            {0, 3, 1, 2}
        };
        for (int[] pair : pairs) {
            if (isParallel(
                dots[pair[0]],
                dots[pair[1]],
                dots[pair[2]],
                dots[pair[3]]
            )) {
                return 1;
            }
        }
        return 0;
    }
    
    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        int dx1 = b[0] - a[0], dy1 = b[1] - a[1];
        int dx2 = d[0] - c[0], dy2 = d[1] - c[1];
        return dy1 * dx2 == dy2 * dx1;
    }
}
