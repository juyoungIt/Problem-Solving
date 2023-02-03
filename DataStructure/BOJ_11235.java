// BOJ - 11235
// Problem Sheet - https://www.acmicpc.net/problem/11235

import java.util.*;
import java.io.*;

public class Main {

    static class Candidate implements Comparable<Candidate> {
        private final String name; // 이름
        private final int count; // 득표수

        public Candidate(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() { return this.name; }
        public int getCount() { return this.count; }

        @Override
        public int compareTo(Candidate candidate) {
            if(this.count != candidate.getCount()) {
                return Integer.compare(this.count, candidate.getCount()) * -1;
            } else {
                return this.name.compareTo(candidate.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Candidate> pQueue = new PriorityQueue<>();
        Map<String, Integer> countMapper = new HashMap<>();

        int n = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            String name = bf.readLine();
            if(!countMapper.containsKey(name)) {
                countMapper.put(name, 1);
            } else {
                countMapper.put(name, countMapper.get(name) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : countMapper.entrySet()) {
            pQueue.add(new Candidate(entry.getKey(), entry.getValue()));
        }

        // 종합된 결과를 출력함
        int maxCount = pQueue.peek().getCount();
        while(!pQueue.isEmpty() && pQueue.peek().getCount() == maxCount) {
            System.out.println(pQueue.poll().getName());
        }

        bf.close();
        System.exit(0);
    }
}