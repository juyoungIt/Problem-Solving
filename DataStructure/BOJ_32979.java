// BOJ - 32979
// Problem Sheet - https://www.acmicpc.net/problem/32979

import java.util.*;
import java.io.*;

public class Main {

    private static int N, T;
    private static Deque<Integer> deque;
    private static int[] seq;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        String[] row = br.readLine().split(" ");
        deque = new ArrayDeque<>(2 * N);
        for (int i=0 ; i<2*N ; i++) {
            deque.addFirst(Integer.parseInt(row[i]));
        }
        seq = new int[T];
        row = br.readLine().split(" ");
        for (int i=0 ; i<T ; i++) {
            seq[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<T ; i++) {
            for (int j=0 ; j<seq[i]-1 ; j++) {
                deque.addFirst(deque.pollLast());
            }
            sb.append(deque.peekLast()).append(" ");
        }
        return sb.toString();
    }
}