// BOJ - 26473
// Problem Sheet - https://www.acmicpc.net/problem/26473

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int[] A = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int maxContinuousLength = 1;
            int continuousLength = 1;
            for (int i=1 ; i<N ; i++) {
                if (A[i - 1] + 1 == A[i]) {
                    continuousLength++;
                } else {
                    maxContinuousLength = Math.max(continuousLength, maxContinuousLength);
                    continuousLength = 1;
                }
            }
            maxContinuousLength = Math.max(continuousLength, maxContinuousLength);
            sb.append(maxContinuousLength).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}