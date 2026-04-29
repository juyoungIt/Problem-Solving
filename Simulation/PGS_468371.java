import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] periods = new int[n];
        int[][] range = new int[n][2];
        int lcm = 1;
        for (int i=0 ; i<n ; i++) {
            periods[i] = 0;
            for (int j=0 ; j<3 ; j++) {
                periods[i] += signals[i][j];
            }
            range[i][0] = signals[i][0];
            range[i][1] = range[i][0] + signals[i][1];
            lcm = getLCM(lcm, periods[i], getGCD(lcm, periods[i]));
        }
        for (int i=1 ; i<=lcm ; i++) {
            boolean isValid = true;
            for (int j=0 ; j<n ; j++) {
                int pos = (i - 1) % periods[j];
                if (!(range[j][0] <= pos && pos < range[j][1])) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return i;
        }
        return -1; 
    }
    
    private int getGCD(int a, int b) {
        int divider;
        while (b > 0) {
            divider = a % b;
            a = b;
            b = divider;
        }
        return a;
    }
    
    private int getLCM(int a, int b, int gcd) {
        return a * b / gcd;
    }
}
