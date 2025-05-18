// BOJ - 4408
// Problem Sheet - https://www.acmicpc.net/problem/4408

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static final String TIE = "tie";

    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final String party;
        private int votes;

        public Candidate(String name, String party) {
            this.name = name;
            this.party = party;
            this.votes = 0;
        }

        public String getParty() { return this.party; }
        public int getVotes() { return this.votes; }
        public void addVotes() { this.votes++; }

        @Override
        public int compareTo(Candidate c) {
            return c.getVotes() - this.votes;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Candidate> candidates = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String name = br.readLine();
            String party = br.readLine();
            candidates.put(name, new Candidate(name, party));
        }
        int m = Integer.parseInt(br.readLine());
        for (int i=0 ; i<m ; i++) {
            String name = br.readLine();
            if (!candidates.containsKey(name)) continue;
            candidates.get(name).addVotes();
        }
        List<Candidate> top2 = candidates.values().stream()
                .sorted()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(top2.get(0).getVotes() == top2.get(1).getVotes() ? TIE : top2.get(0).getParty());
        br.close();
    }
}