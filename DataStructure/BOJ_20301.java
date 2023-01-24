// BOJ - 20301
// Problem Sheet - https://www.acmicpc.net/problem/20301

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>(); // deque

        int n = Integer.parseInt(st.nextToken()); // 원소의 수
        int k = Integer.parseInt(st.nextToken()); // 이동하는 간격의 수
        int m = Integer.parseInt(st.nextToken()); // 탐색방향 반전주기

        int reverseCount = 0; // 반전주기 현황
        boolean direction = false; // 탐색방향 (false: 오른쪽, true: 왼쪽)

        // queue의 초기상태 세팅
        for(int i=1 ; i<=n ; i++) {
            deque.add(i);
        }

        // queue가 empty가 될 때까지 다음을 반복
        while(!deque.isEmpty()) {
            if(direction) { // 탐색방향이 왼쪽인 경우
                for(int i=0 ; i<k-1 ; i++) {
                    deque.addFirst(deque.pollLast());
                }
                System.out.println(deque.pollLast());
            } else { // 탐색방향이 오른쪽인 경우
                for(int i=0 ; i<k-1 ; i++) {
                    deque.addLast(deque.pollFirst());
                }
                System.out.println(deque.pollFirst());
            }
            reverseCount++;
            if(reverseCount == m) {
                direction = !direction;
                reverseCount = 0;
            }
        }

        bf.close();
        System.exit(0);
    }
}