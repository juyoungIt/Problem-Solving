// PGS - 12921
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12921

class Solution {
    public int solution(int n) {
        boolean[] isComposite = new boolean[n + 1];
        isComposite[0] = true;
        isComposite[1] = true;
        for (int i=2; i*i<=n; i++) {
            if (isComposite[i]) continue;
            for (int j=i*i; j<=n; j+=i) {
                isComposite[j] = true;
            }
        }
        int primeCount = 0;
        for (int i=2; i<=n; i++) {
            if (!isComposite[i]) {
                primeCount++;
            }
        }
        return primeCount;
    }
}
