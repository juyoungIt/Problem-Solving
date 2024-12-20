// BOJ - 5602
// Problem Sheet - https://www.acmicpc.net/problem/5602

import java.util.*;
import java.io.*;

public class Main {

    static class Candidate implements Comparable<Candidate> {
        private final int index;
        private int count;

        public Candidate(int index) {
            this.index = index;
            this.count = 0;
        }

        public int getIndex() { return this.index; }
        public int getCount() { return this.count; }
        public void addCount() { this.count++; }

        @Override
        public int compareTo(Candidate c) {
            return c.getCount() - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Candidate[] candidates = new Candidate[m];
        for (int i=0 ; i<n ; i++) {
            input = br.readLine().split(" ");
            for (int j=0 ; j<m ; j++) {
                if (candidates[j] == null) {
                    candidates[j] = new Candidate(j + 1);
                }
                int code = Integer.parseInt(input[j]);
                if (code == 1) candidates[j].addCount();
            }
        }
        Arrays.sort(candidates);

        for (Candidate candidate : candidates) {
            sb.append(candidate.getIndex()).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}