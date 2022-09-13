// BOJ - 12761
// Problem Sheet - https://www.acmicpc.net/problem/12761

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] bridge = new int[100000+1]; // 돌 다리에 대한 정보 (0 - 방문하지 않은 상태)
        Queue<Integer> queue = new LinkedList<>(); // bfs를 수행하기 위해 생성한 queue
        boolean isReached = false; // 도달여부

        int a = Integer.parseInt(st.nextToken()); // 스카이콩콩 A의 힘
        int b = Integer.parseInt(st.nextToken()); // 스카이콩콩 B의 힘
        int n = Integer.parseInt(st.nextToken()); // 동규의 현재 위치
        int m = Integer.parseInt(st.nextToken()); // 주미의 현재 위치

        int[] increments = {-1, 1, -a, a, -b, b, a, b}; // 이동할 수 있는 방법의 종류

        queue.add(n);
        while(!queue.isEmpty() && !isReached) {
            for(int i=0 ; i<8 ; i++) {
                int tmp = queue.peek();
                if(i>=0 && i<=5)
                    tmp += increments[i];
                else
                    tmp *= increments[i];
                if(validation(tmp) && bridge[tmp] == 0) {
                    bridge[tmp] = bridge[queue.peek()] + 1;
                    queue.add(tmp);
                    if(tmp == m) {
                        isReached = true;
                        break;
                    }
                }
            }
            queue.poll();
        }

        System.out.println(bridge[m]);

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x) {
        return (x>=0 && x<=100000);
    }
}