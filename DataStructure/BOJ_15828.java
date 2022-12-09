// BOJ - 15828
// Problem Sheet - https://www.acmicpc.net/problem/15828

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 버퍼의 크기
        Queue<Integer> queue = new LinkedList<>(); // 패킷을 저장하는 queue

        while(true) {
            String input = bf.readLine(); // 한 개의 요청을 읽어옴
            if(input.equals("-1")) break;
            else if(input.equals("0")) queue.poll();
            else if(queue.size() < n) queue.add(Integer.parseInt(input));
        }

        if(queue.size() == 0)
            System.out.println("empty");
        else {
            for(int packet : queue)
                System.out.print(packet + " ");
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }
}