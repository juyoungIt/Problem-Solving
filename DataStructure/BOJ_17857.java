// BOJ - 17857
// Problem Sheet - https://www.acmicpc.net/problem/17857

import java.util.*;
import java.io.*;

public class Main {

    static class Candidate {
        private final int id;
        private final int k;

        public Candidate(int id, int k) {
            this.id = id;
            this.k = k;
        }

        public int getId() { return this.id; }
        public int getK() { return this.k; }
    }

    private static int n;
    private static final Queue<Candidate> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            queue.add(new Candidate(i + 1, Integer.parseInt(row[i])));
        }
        br.close();
    }

    private static int solve() {
        while (queue.size() > 1) {
            Candidate front = queue.peek();
            int count = (front.getK()-1)%queue.size();
            for (int i=0 ; i<count ; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll().getId();
    }
}