// BOJ - 17952
// Problem Sheet - https://www.acmicpc.net/problem/17952

import java.util.*;
import java.io.*;

public class Main {

    static class Assignment {
        private final int score; // 만점 점수
        private int remainTime; // 해결을 위한 남은 시간

        public Assignment(int score, int remainTime) {
            this.score = score;
            this.remainTime = remainTime;
        }

        public boolean isFinished() { return this.remainTime == 0; }
        public void execute() { this.remainTime--; }
        public int getScore() { return this.score; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Assignment> assignments = new Stack<>(); // 과제들을 저장
        int answer = 0; // 총 얻은 스코어

        int n = Integer.parseInt(bf.readLine()); // 이번학기가 총 몇 분인 가?
        for(int i=0 ; i<n ; i++) {
            if(!assignments.isEmpty() && assignments.peek().isFinished())
                answer += assignments.pop().getScore();
            String[] inputs = bf.readLine().split(" ");
            if(inputs[0].equals("1")) {
                int totalScore = Integer.parseInt(inputs[1]);
                int timeCost = Integer.parseInt(inputs[2]);
                assignments.push(new Assignment(totalScore, timeCost));
            }
            if(!assignments.isEmpty())
                assignments.peek().execute();
        }
        if(!assignments.isEmpty() && assignments.peek().isFinished())
            answer += assignments.pop().getScore();

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        bf.close();
        System.exit(0);
    }
}