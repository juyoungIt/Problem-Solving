// BOJ - 23320
// Problem Sheet - https://www.acmicpc.net/problem/23320

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int relativeEvaluationCount = (int) (n * x * 0.01);
        int absoluteEvaluationCount = (int) Arrays.stream(seq).filter(s -> s >= y).count();

        System.out.printf("%d %d\n", relativeEvaluationCount, absoluteEvaluationCount);

        br.close();
        System.exit(0);
    }
}