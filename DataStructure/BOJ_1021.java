// BOJ - 1021
// Problem Sheet - https://www.acmicpc.net/problem/1021

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int result = 0; // 2, 3번 연산의 최솟값

        int n = Integer.parseInt(st.nextToken()); // queue의 크기
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            deque.add(i); // 해당 위치의 원래 인덱스를 저장함
        }

        int m = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 갯수
        st = new StringTokenizer(bf.readLine()); // 뽑아내려고 하는 수의 위치 (초기 덱에 대한 인덱스임)
        for(int i=0 ; i<m ; i++) {
            int targetIdx = Integer.parseInt(st.nextToken()); // 목표 인덱스
            int realLocation = deque.indexOf(targetIdx); // target index의 실제 위치
            if(realLocation <= deque.size() / 2) { // 왼쪽
                while(deque.getFirst() != targetIdx) {
                    deque.addLast(deque.pollFirst());
                    result++;
                }
                deque.pollFirst();
            } else { // 오른쪽
                while(deque.getFirst() != targetIdx) {
                    deque.addFirst(deque.pollLast());
                    result++;
                }
                deque.pollFirst();
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}