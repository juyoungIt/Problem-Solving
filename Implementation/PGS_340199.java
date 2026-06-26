// PGS - 340199
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/340199

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);
        while (walletMin < billMin || walletMax < billMax) {
            billMax /= 2;
            int nextBillMin = Math.min(billMin, billMax);
            int nextBillMax = Math.max(billMin, billMax);
            billMin = nextBillMin;
            billMax = nextBillMax;
            answer++;
        }
        return answer;
    }
}
