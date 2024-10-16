// BOJ - 24509
// Problem Sheet - https://www.acmicpc.net/problem/24509

import java.util.*;
import java.io.*;

public class Main {

    static class Score implements Comparable<Score> {
        private final int studentNumber;
        private final int score;

        public Score(int studentNumber, int score) {
            this.studentNumber = studentNumber;
            this.score = score;
        }

        public int getStudentNumber() { return this.studentNumber; }
        public int getScore() { return this.score; }

        @Override
        public int compareTo(Score s) {
            if (this.score == s.getScore()) {
                return this.studentNumber - s.getStudentNumber();
            }
            return s.getScore() - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Score> kor = new PriorityQueue<>();
        PriorityQueue<Score> eng = new PriorityQueue<>();
        PriorityQueue<Score> mat = new PriorityQueue<>();
        PriorityQueue<Score> sci = new PriorityQueue<>();
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            kor.add(new Score(x, a));
            eng.add(new Score(x, b));
            mat.add(new Score(x, c));
            sci.add(new Score(x, d));
        }

        boolean[] winners = new boolean[n + 1];
        while (!kor.isEmpty()) {
            if (winners[kor.peek().getStudentNumber()]) {
                kor.poll();
                continue;
            }
            winners[kor.peek().getStudentNumber()] = true;
            sb.append(kor.poll().getStudentNumber()).append(" ");
            break;
        }
        while (!eng.isEmpty()) {
            if (winners[eng.peek().getStudentNumber()]) {
                eng.poll();
                continue;
            }
            winners[eng.peek().getStudentNumber()] = true;
            sb.append(eng.poll().getStudentNumber()).append(" ");
            break;
        }
        while (!mat.isEmpty()) {
            if (winners[mat.peek().getStudentNumber()]) {
                mat.poll();
                continue;
            }
            winners[mat.peek().getStudentNumber()] = true;
            sb.append(mat.poll().getStudentNumber()).append(" ");
            break;
        }
        while (!sci.isEmpty()) {
            if (winners[sci.peek().getStudentNumber()]) {
                sci.poll();
                continue;
            }
            winners[sci.peek().getStudentNumber()] = true;
            sb.append(sci.poll().getStudentNumber()).append(" ");
            break;
        }

        System.out.println(sb);

        br.close();
    }
}