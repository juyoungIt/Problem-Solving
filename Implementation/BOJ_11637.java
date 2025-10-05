// BOJ - 11637
// Problem Sheet - https://www.acmicpc.net/problem/11637

import java.util.*;
import java.io.*;

public class Main {

    static class Candidate implements Comparable<Candidate> {
        int number;
        int count;

        public Candidate(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Candidate c) {
            return c.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int totalCount = 0;
            PriorityQueue<Candidate> pq = new PriorityQueue<>();
            for (int i=1 ; i<=n ; i++) {
                int count = Integer.parseInt(br.readLine());
                totalCount += count;
                pq.add(new Candidate(i, count));
            }
            Candidate first = pq.poll();
            Candidate second = pq.poll();
            if (first.count == second.count) {
                sb.append("no winner\n");
            } else {
                if (first.count * 2 > totalCount) {
                    sb.append("majority ");
                } else {
                    sb.append("minority ");
                }
                sb.append("winner ").append(first.number).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

}
