// BOJ - 9713
// Problem Sheet - https://www.acmicpc.net/problem/9713

import java.io.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            int upperBound = Integer.parseInt(br.readLine());
            sb.append(IntStream.iterate(1, n -> n + 1)
                    .filter(n -> n % 2 == 1)
                    .takeWhile(n -> n <= upperBound)
                    .sum());
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}