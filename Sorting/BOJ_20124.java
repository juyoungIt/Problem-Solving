// BOJ - 20124
// Problem Sheet - https://www.acmicpc.net/problem/20124

import java.util.*;
import java.io.*;

public class Main {

    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final int score;

        public Candidate(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() { return this.name; }
        public int getScore() { return this.score; }

        @Override
        public int compareTo(Candidate c) {
            if (this.score == c.getScore()) {
                return this.name.compareTo(c.getName());
            }
            return c.getScore() - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Candidate> candidates = new ArrayList<>();
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            candidates.add(new Candidate(name, score));
        }
        Collections.sort(candidates);

        System.out.println(candidates.get(0).getName());

        br.close();
        System.exit(0);
    }
}