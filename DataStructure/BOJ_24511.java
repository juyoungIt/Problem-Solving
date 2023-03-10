// BOJ - 24511
// Problem Sheet - https://www.acmicpc.net/problem/24511

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int sizeOfStackQueue = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>(sizeOfStackQueue);

        st = new StringTokenizer(bf.readLine());
        List<Boolean> isStack = new ArrayList<>(sizeOfStackQueue);
        for(int i=0 ; i<sizeOfStackQueue ; i++) {
            isStack.add(Integer.parseInt(st.nextToken()) == 1);
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<sizeOfStackQueue ; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(!isStack.get(i)) {
                deque.addFirst(value);
            }
        }

        int numberOfElements = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfElements ; i++) {
            deque.addLast(Integer.parseInt(st.nextToken()));
        }

        for(int i=0 ; i<numberOfElements ; i++) {
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}