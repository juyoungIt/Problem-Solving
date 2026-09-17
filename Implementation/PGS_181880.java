// PGS - 181880
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181880

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int num : num_list) {
            answer += getDivideCount(num);
        }
        return answer;
    }
    
    private int getDivideCount(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 != 0) {
                n--;
            }
            n /= 2;
            count++;
        }
        return count;
    }
}
