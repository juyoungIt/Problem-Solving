// BOJ - 1781
// Problem Sheet - https://www.acmicpc.net/problem/1781

import java.util.*;
import java.io.*;

class Problem implements Comparable<Problem> {
    private final int due; // 데드라인
    private final long reward; // 문제를 풀었을 때 받는 컵라면의 수

    public Problem(int due, long reward) {
        this.due = due;
        this.reward = reward;
    }

    public int getDue() { return this.due; }
    public long getReward() { return this.reward; }

    @Override
    public int compareTo(Problem p) {
        if(this.due != p.getDue())
            return Integer.compare(this.due, p.getDue());
        else
            return Long.compare(this.reward, p.getReward()) * -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine()); // 문제의 수
        PriorityQueue<Problem> problems = new PriorityQueue<>();  // 입력받은 문제의 리스트를 저장
        PriorityQueue<Long> solved = new PriorityQueue<>(); // 풀이한 문제들을 저장
        long answer = 0;

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int due = Integer.parseInt(st.nextToken());
            long reward = Long.parseLong(st.nextToken());
            problems.add(new Problem(due, reward));
        }

        // 정렬된 문제의 리스트에 대해서 다음을 반복함
        while(!problems.isEmpty()) {
            Problem p = problems.poll();
            if(solved.size() >= p.getDue()) {
                if(solved.peek() < p.getReward())
                    solved.poll(); // 가장 작은 값 하나를 빼고
                else continue;
            }
            solved.add(p.getReward()); // 값을 추가함
        }

        // 풀이한 문제를 통해 얻을 수 있는 합을 계산함
        while(!solved.isEmpty())
            answer += solved.poll();

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}