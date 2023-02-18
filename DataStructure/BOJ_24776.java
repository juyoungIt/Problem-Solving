// BOJ - 24776
// Problem Sheet - https://www.acmicpc.net/problem/24776

import java.util.*;
import java.io.*;

public class Main {

    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final int count;

        public Candidate(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() { return this.name; }
        public int getCount() { return this.count; }

        @Override
        public int compareTo(Candidate candidate) {
            return Integer.compare(this.count, candidate.getCount()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> voteCountMapper = new HashMap<>();
        PriorityQueue<Candidate> candidates = new PriorityQueue<>();

        while(true) {
            String name = bf.readLine();
            if(name.equals("***")) {
                break;
            }
            if(!voteCountMapper.containsKey(name)) {
                voteCountMapper.put(name, 1);
            } else {
                voteCountMapper.put(name, voteCountMapper.get(name) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : voteCountMapper.entrySet()) {
            candidates.add(new Candidate(entry.getKey(), entry.getValue()));
        }

        Candidate winner = candidates.poll();
        if(winner.getCount() == candidates.peek().getCount()) {
            System.out.println("Runoff!");
        } else {
            System.out.println(winner.getName());
        }

        bf.close();
        System.exit(0);
    }
}