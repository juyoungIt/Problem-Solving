// BOJ - 14235
// Problem Sheet - https://www.acmicpc.net/problem/14235

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(bf.readLine()); // 아이들과 거점지를 방문한 횟수
        for(int i=0 ; i<n ; i++) {
            String[] input = bf.readLine().split(" ");
            if(input[0].equals("0"))
                System.out.println((queue.isEmpty()) ? -1 : queue.poll());
            else {
                for(int j=1 ; j<=Integer.parseInt(input[0]) ; j++)
                    queue.add(Integer.parseInt(input[j]));
            }
        }

        bf.close();
        System.exit(0);
    }
}