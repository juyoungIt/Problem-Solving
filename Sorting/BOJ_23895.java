// BOJ - 23895
// Problem Sheet - https://www.acmicpc.net/problem/23895

import java.util.*;
import java.io.*;

public class Main {

    private static final String MESSAGE_FORMAT = "Case #%d: %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=T ; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int[] A = new int[N];
            input = br.readLine().split(" ");
            for (int j=0 ; j<N ; j++) {
                A[j] = Integer.parseInt(input[j]);
            }
            Arrays.sort(A);

            int count = 0;
            for (int j=0 ; j<N ; j++) {
                B -= A[j];
                if (B < 0) break;
                count++;
            }
            sb.append(String.format(MESSAGE_FORMAT, i, count));
        }

        System.out.println(sb);
        br.close();
    }
}