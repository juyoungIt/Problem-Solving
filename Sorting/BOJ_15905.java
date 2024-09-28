// BOJ - 15905
// Problem Sheet - https://www.acmicpc.net/problem/15905

import java.util.*;
import java.io.*;

public class Main {

    static class Student implements Comparable<Student> {
        private final int solved;
        private final int penalty;

        public Student(int solved, int penalty) {
            this.solved = solved;
            this.penalty = penalty;
        }

        public int getSolved() { return this.solved; }
        public int getPenalty() { return this.penalty; }

        @Override
        public int compareTo(Student s) {
            if (this.solved == s.getSolved()) {
                return this.penalty - s.getPenalty();
            }
            return s.getSolved() - this.solved;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Student> ranks = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int solved = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());
            ranks.add(new Student(solved, penalty));
        }
        Collections.sort(ranks);

        int giftCount = 0;
        for (int i=5 ; i<n ; i++) {
            if (ranks.get(4).getSolved() == ranks.get(i).getSolved()) {
                giftCount++;
            } else {
                break;
            }
        }
        System.out.println(giftCount);

        br.close();
        System.exit(0);
    }
}