// BOJ - 1966
// Problem Sheet - https://www.acmicpc.net/problem/1966

import java.util.*;
import java.io.*;

public class Main {

    static class Doc implements Comparable<Doc> {
        private final int idx; // 처음 queue에 위치한 인덱스
        private final int weight; // 가중치 값

        public Doc(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        public int getIdx() { return this.idx; }
        public int getWeight() { return this.weight; }

        @Override
        public int compareTo(Doc doc) {
            return Integer.compare(this.weight, doc.getWeight()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        Deque<Doc> printSeq = new LinkedList<>(); // 프린트 순서를 저장한 queue
        PriorityQueue<Integer> weightQueue = new PriorityQueue<>(Collections.reverseOrder()); // 가중치 저장

        StringTokenizer st;
        for(int i=0 ; i<tcSize ; i++) {
            st = new StringTokenizer(bf.readLine());
            int docCnt = Integer.parseInt(st.nextToken()); // 문서의 수
            int target = Integer.parseInt(st.nextToken()); // 번째 수가 궁금한 문서
            int answer = 0; // 기다린 횟수

            // n개의 중요도 정보를 수집함
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<docCnt ; j++) {
                int weight = Integer.parseInt(st.nextToken());
                weightQueue.add(weight);
                printSeq.addLast(new Doc(j, weight));
            }

            // 목표로 하는 문서가 출력가능할 때까지 다음을 반복
            while(true) {
                if(printSeq.getFirst().getWeight() < weightQueue.peek())
                    printSeq.addLast(printSeq.pollFirst());
                else {
                    if(printSeq.getFirst().getIdx() == target)
                        break;
                    answer++;
                    weightQueue.poll();
                    printSeq.removeFirst();
                }
            }

            System.out.println(answer+1);
            printSeq.clear(); // 재사용을 위해 초기화
            weightQueue.clear(); // 재사용을 위해 초기화
        }

        bf.close();
        System.exit(0);
    }
}