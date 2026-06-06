// PGS - 12977
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12977

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        int answer = 0;
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrimeNumber(sum)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    private boolean isPrimeNumber(int n) {
        for (int i=2; i<n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
