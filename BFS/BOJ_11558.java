// BOJ - 11558
// Problem Sheet - https://www.acmicpc.net/problem/11558

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        int[] answers = new int[t]; // 각 테스트 케이스에 대한 솔루션 저장

        // 각각의 테스트 케이스에 대하여 다음을 반복
        for(int i=0 ; i<t ; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int n = Integer.parseInt(bf.readLine()); // 플레이어의 수
            int[] players = new int[n+1];
            boolean[] visit = new boolean[n+1]; // 각 플레이어에 대한 방문정보
            for(int j=1 ; j<=n ; j++)
                players[j] = Integer.parseInt(bf.readLine());
            int count = 0;

            queue.add(1);
            while(!queue.isEmpty()) {
                if(queue.peek() == n) {
                    answers[i] = count;
                    break;
                }
                if(!visit[players[queue.peek()]]) {
                    count++;
                    visit[players[queue.peek()]] = true;
                    queue.add(players[queue.peek()]);
                }
                queue.poll();
            }
        }

        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}