// BOJ - 32752
// Problem Sheet - https://www.acmicpc.net/problem/32752

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] subA = new int[R - L + 1];
        System.arraycopy(A, L-1, subA, 0, R - L + 1);
        Arrays.sort(subA);
        System.arraycopy(subA, 0, A, L-1, subA.length);

        boolean answer = true;
        for (int i=1 ; i<N ; i++) {
            if (A[i - 1] > A[i]) {
                answer = false;
                break;
            }
        }

        System.out.println(answer ? 1 : 0);
        br.close();
    }
}