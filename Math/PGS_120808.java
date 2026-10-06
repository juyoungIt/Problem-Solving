// PGS - 120808
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120808

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom = getLCM(denom1, denom2, getGCD(Math.max(denom1, denom2), Math.min(denom1, denom2)));
        int numer = numer1 * (denom / denom1) + numer2 * (denom / denom2);
        int gcd = getGCD(Math.max(denom, numer), Math.min(denom, numer));
        int[] answer = new int[2];
        answer[0] = numer / gcd;
        answer[1] = denom / gcd;
        return answer;
    }
    
    private static int getGCD(int numberA, int numberB) {
        if(numberB == 0) {
            return numberA;
        }
        return getGCD(numberB, numberA % numberB);
    }
 
    private static int getLCM(int numberA, int numberB, int gcd) {
        return numberA * numberB / gcd;
    }
}
