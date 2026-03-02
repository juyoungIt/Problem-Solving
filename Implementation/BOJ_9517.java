// BOJ - 9517
// Problem Sheet - https://www.acmicpc.net/problem/9517

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int remains = 210;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=k ; i<=8 ; i++) {
            deque.add(i);
        }
        for (int i=1 ; i<k ; i++) {
            deque.add(i);
        }
        int answer = -1;
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char z = st.nextToken().charAt(0);
            if (remains - t <= 0) {
                answer = deque.peekFirst();
                break;
            }
            if (z == 'T') {
                deque.addLast(deque.pollFirst());
            }
            remains -= t;
        }
        System.out.println(answer);
        br.close();
    }
}
