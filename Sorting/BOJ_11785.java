// BOJ - 11785
// Problem Sheet - https://www.acmicpc.net/problem/11785

import java.util.*;
import java.io.*;

public class Main {

    private static final String FORMAT_STRING = "Case %d: %d %d %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=T ; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int[] acc = new int[N];
            acc[0] = arr[0];
            for (int j=1 ; j<N ; j++) {
                acc[j] = acc[j - 1] + arr[j];
            }
            int[] result = new int[3];
            for (int j=0 ; j<N ; j++) {
                if (acc[j] > L) break;
                result[0]++;
                result[1] = acc[j];
                result[2] += acc[j];
            }
            sb.append(String.format(FORMAT_STRING, i, result[0], result[1], result[2]));
        }

        System.out.println(sb);
        br.close();
    }
}