// BOJ - 10866
// Problem Sheet - https://www.acmicpc.net/problem/10866

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dequeue = new ArrayDeque<>();

        int n = Integer.parseInt(bf.readLine()); // 명령어의 수
        for(int i=0 ; i<n ; i++) {
            String[] commands = bf.readLine().split(" ");
            if(commands[0].equals("push_front")) {
                dequeue.addFirst(Integer.parseInt(commands[1]));
            } else if(commands[0].equals("push_back")) {
                dequeue.addLast(Integer.parseInt(commands[1]));
            } else if(commands[0].equals("pop_front")) {
                if(dequeue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(dequeue.pollFirst());
            } else if(commands[0].equals("pop_back")) {
                if(dequeue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(dequeue.pollLast());
            } else if(commands[0].equals("size")) {
                System.out.println(dequeue.size());
            } else if(commands[0].equals("empty")) {
                if(dequeue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(commands[0].equals("front")) {
                if(dequeue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(dequeue.getFirst());
            } else {
                if(dequeue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(dequeue.getLast());
            }
        }

        bf.close();
        System.exit(0);
    }
}