// BOJ - 6160
// Problem Sheet - https://www.acmicpc.net/problem/6160

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Cow {
        private final int i;
        private final int a;
        private final int b;

        public Cow(int i, int a, int b) {
            this.i = i;
            this.a = a;
            this.b = b;
        }

        public int getI() { return this.i; }
        public int getA() { return this.a; }
        public int getB() { return this.b; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Cow> firstRounds = new ArrayList<>(N);
        for (int i=1 ; i<=N ; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            firstRounds.add(new Cow(i, A, B));
        }
        firstRounds.sort((c1, c2) -> c2.getA() - c1.getA());

        List<Cow> secondRounds = firstRounds.stream()
                .limit(K)
                .sorted((c1, c2) -> c2.getB() - c1.getB())
                .collect(Collectors.toList());

        System.out.println(secondRounds.get(0).getI());
        br.close();
    }
}