// BOJ - 26042
// Problem Sheet - https://www.acmicpc.net/problem/26042

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> waitings = new LinkedList<>(); // 대기열을 표시하는 queue
        StringTokenizer st;

        int maxSize = 0; // 대기열의 최고크기
        PriorityQueue<Integer> waitingNumbers = new PriorityQueue<>(); // 기다리는 사람 번호

        int n = Integer.parseInt(bf.readLine()); // 정보의 수
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            String type = st.nextToken();
            if(type.equals("1")) { // type 1인 경우
                int number = Integer.parseInt(st.nextToken());
                waitings.add(number);
                if(maxSize < waitings.size()) {
                    maxSize = waitings.size();
                    waitingNumbers.clear();
                    waitingNumbers.add(number);
                } else if(maxSize == waitings.size()) {
                    waitingNumbers.add(number);
                }
            } else { // type 2인 경우
                waitings.pollFirst();
            }
        }

        System.out.println(maxSize + " " + waitingNumbers.poll());

        bf.close();
        System.exit(0);
    }
}