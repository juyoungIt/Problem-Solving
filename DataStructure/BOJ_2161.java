// BOJ - 2161
// Problem Sheet - https://www.acmicpc.net/problem/2161

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>(); // 문제풀이에 사용하는 queue

        // 초기 queue의 상태를 구성함
        for(int i=1 ; i<=n ; i++)
            queue.add(i);

        while(queue.size() > 1) {
            System.out.print(queue.poll() + " "); // 제일 위의 카드 한 장을 버림
            if(queue.size() > 1)
                queue.add(queue.poll()); // 제일 위의 카드 한 장을 바닥으로 넣음
        }
        System.out.println(queue.poll()); // 마지막 한 장 남은 카드의 수를 출력함

        bf.close();
        System.exit(0);
    }
}