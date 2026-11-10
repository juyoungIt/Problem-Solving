// PGS - 181926
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181926

class Solution {
    public int solution(int n, String control) {
        for (int i=0; i<control.length(); i++) {
            switch (control.charAt(i)) {
                case 'w':
                    n++;
                    break;
                case 'a':
                    n -= 10;
                    break;
                case 's':
                    n--;
                    break;
                case 'd':
                    n += 10;
                    break;
                default:
                    throw new IllegalArgumentException("invalid control...");
            }
            
        }
        return n;
    }
}
