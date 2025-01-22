// BOJ - 17298
// Problem Sheet - https://www.acmicpc.net/problem/17298

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] oBigs = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i=0 ; i<N ; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                oBigs[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        for (int oBig : oBigs) {
            sb.append(oBig > 0 ? oBig : -1).append(" ");
        }
        return sb.toString();
    }
}