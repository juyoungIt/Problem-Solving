// PGS - 12919
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12919

class Solution {
    public String solution(String[] seoul) {
        int index;
        for (index=0; index<seoul.length; index++) {
            if (seoul[index].equals("Kim")) {
                break;
            }
        }
        return String.format("김서방은 %d에 있다", index);
    }
}
