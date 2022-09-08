// BOJ - 2109
// Problem Sheet - https://www.acmicpc.net/problem/2109

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private final int price; // 강의료
    private final int date;  // 가능날짜

    public Node(int price, int date) {
        this.price = price;
        this.date = date;
    }

    public int getPrice() { return this.price; }
    public int getDate() { return this.date; }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(node.getPrice(), this.price);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] timeTable = new int[10000+1]; // 강의정보를 저장하는 테이블
        PriorityQueue<Node> pQueue = new PriorityQueue<>(); // 강의정보 저장
        int answer = 0; // 받을 수 있는 강의료의 최댓값

        int n = Integer.parseInt(bf.readLine()); // 강의요청이 들어온 대학의 수
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int price = Integer.parseInt(st.nextToken());
            int date = Integer.parseInt(st.nextToken());
            pQueue.add(new Node(price, date));
        }

        // 받을 수 있는 강의료가 최대치가 되도록 다음을 반복함
        while(!pQueue.isEmpty()) {
            Node node = pQueue.poll();
            for(int i=node.getDate() ; i>=1 ; i--) {
                if(timeTable[i] == 0) {
                    timeTable[i] = node.getPrice();
                    answer += node.getPrice();
                    break;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}