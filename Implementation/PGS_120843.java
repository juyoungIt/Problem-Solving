// PGS - 120843
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120843

class Solution {
    public int solution(int[] numbers, int k) {
        int index = 0;
        int len = numbers.length;
        while (k > 1) {
            index += 2;
            index %= len;
            k--;
        }
        return numbers[index];
    }
}
