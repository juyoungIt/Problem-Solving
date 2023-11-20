// BOJ - 10599
// Problem Sheet - https://www.acmicpc.net/problem/10599

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int[] ranges = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if(isEnd(ranges)) break;
            int min = getDiff(ranges[1], ranges[2]);
            int max = getDiff(ranges[0], ranges[3]);
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static boolean isEnd(int[] input) {
        return input[0] == 0 && input[1] == 0 && input[2] == 0 && input[3] == 0;
    }

    private static int getDiff(int start, int end) {
        return end - start;
    }
}