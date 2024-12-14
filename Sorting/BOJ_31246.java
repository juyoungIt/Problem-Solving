// BOJ - 31246
// Problem Sheet - https://www.acmicpc.net/problem/31246

import java.util.*;
import java.io.*;

public class Main {

    static class Request implements Comparable<Request> {
        private final int a;
        private final int b;

        public Request(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getDiff() { return a - b; }

        @Override
        public int compareTo(Request r) {
            return r.getDiff() - this.getDiff();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        List<Request> requests = new ArrayList<>(N);
        for (int i=0 ; i<N ; i++) {
            input = br.readLine().split(" ");
            int Ai = Integer.parseInt(input[0]);
            int Bi = Integer.parseInt(input[1]);
            requests.add(new Request(Ai, Bi));
        }
        Collections.sort(requests);

        System.out.println(Math.min(requests.get(K - 1).getDiff(), 0) * -1);
        br.close();
    }
}
