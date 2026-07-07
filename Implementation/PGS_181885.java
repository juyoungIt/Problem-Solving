// PGS - 181885
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181885

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int n = todo_list.length;
        int notFinishedCount = 0;
        for (int i=0; i<n; i++) {
            if (finished[i]) continue;
            notFinishedCount++;
        }
        String[] answer = new String[notFinishedCount];
        int index = 0;
        for (int i=0; i<n; i++) {
            if (finished[i]) continue;
            answer[index++] = todo_list[i];
        }
        return answer;
    }
}
