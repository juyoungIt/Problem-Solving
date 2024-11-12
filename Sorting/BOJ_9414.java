// BOJ - 9414
// Problem Sheet - https://www.acmicpc.net/problem/9414

import java.util.*;
import java.io.*;

public class Main {

    private static final int PAY_LIMIT = 5_000_000;
    private static final String MESSAGE = "Too expensive";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            List<Integer> prices = new ArrayList<>();
            while (true) {
                int L = Integer.parseInt(br.readLine());
                if (L == 0) break;
                prices.add(L);
            }
            prices.sort(Collections.reverseOrder());

            long sum = 0;
            for (int i=0 ; i<prices.size() ; i++) {
                sum += 2 * (long) Math.pow(prices.get(i), i + 1);
            }
            if (sum <= PAY_LIMIT) sb.append(sum).append("\n");
            else sb.append(MESSAGE).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}