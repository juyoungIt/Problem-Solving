// PGS - 161990
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/161990

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = 51, luy = 51, rdx = -1, rdy = -1;
        int w = wallpaper[0].length(), h = wallpaper.length;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        int[] answer = { lux, luy, rdx + 1, rdy + 1 };
        return answer;
    }
}
