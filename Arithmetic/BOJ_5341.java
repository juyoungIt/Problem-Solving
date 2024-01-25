// BOJ - 5341
// Problem Sheet - https://www.acmicpc.net/problem/5341

import java.io.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            sb.append(IntStream.iterate(1, i -> i + 1)
                    .takeWhile(i -> i <= n)
                    .sum());
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}