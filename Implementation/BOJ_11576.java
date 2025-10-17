// BOJ - 11576
// Problem Sheet - https://www.acmicpc.net/problem/11576

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] baseA = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<m ; i++) {
            baseA[i] = Integer.parseInt(st.nextToken());
        }
        int decimal = 0;
        for (int i=0 ; i<m ; i++) {
            decimal += (baseA[i] * (int) Math.pow(a, m - i - 1));
        }
        Deque<Integer> deque = new ArrayDeque<>();
        while (decimal > 0) {
            deque.addFirst(decimal % b);
            decimal /= b;
        }
        StringJoiner sj = new StringJoiner(" ");
        while (!deque.isEmpty()) {
            sj.add(deque.pollFirst().toString());
        }
        System.out.println(sj.toString());
        br.close();
    }
}
