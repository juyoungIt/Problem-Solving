// BOJ - 26265
// Problem Sheet - https://www.acmicpc.net/problem/26265

import java.util.*;
import java.io.*;

public class Main {

    static class Pair implements Comparable<Pair> {
        private final String mentor;
        private final String mentee;

        public Pair(String mentor, String mentee) {
            this.mentor = mentor;
            this.mentee = mentee;
        }

        public String getMentor() { return this.mentor; }
        public String getMentee() { return this.mentee; }

        @Override
        public int compareTo(Pair p) {
            if (this.mentor.equals(p.getMentor())) {
                return p.getMentee().compareTo(this.mentee);
            }
            return this.mentor.compareTo(p.getMentor());
        }

        @Override
        public String toString() {
            return this.mentor + " " + this.mentee;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String mentor = st.nextToken();
            String mentee = st.nextToken();
            pairs.add(new Pair(mentor, mentee));
        }
        Collections.sort(pairs);

        for (Pair pair : pairs) {
            sb.append(pair).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}