// BOJ - 11652
// Problem Sheet - https://www.acmicpc.net/problem/11652

import java.util.*;
import java.io.*;

public class Main {
    static class CardInfo implements Comparable<CardInfo> {
        private final long number; // 카드에 적힌 수
        private final int count; // 등장한 횟수

        public CardInfo(long number, int count) {
            this.number = number;
            this.count = count;
        }

        public long getNumber() { return this.number; }
        public int getCount() { return this.count; }

        @Override
        public int compareTo(CardInfo card) {
            if(this.count != card.getCount()) return Integer.compare(this.count, card.getCount()) * -1;
            else return Long.compare(this.number, card.getNumber());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 숫자 카드의 수
        Map<Long, Integer> countMapper = new HashMap<>(); // 각 카드에 등장한 수에 대한 빈도 수 저장
        PriorityQueue<CardInfo> pq = new PriorityQueue<>();

        // 가진 카드 정보를 입력받아 구성함
        for(int i=0 ; i<n ; i++) {
            long card = Long.parseLong(bf.readLine());
            if(countMapper.get(card) == null) countMapper.put(card, 1);
            else countMapper.put(card, countMapper.get(card) + 1);
        }

        for(Map.Entry<Long, Integer> card : countMapper.entrySet())
            pq.add(new CardInfo(card.getKey(), card.getValue()));

        System.out.println(pq.peek().getNumber());

        bf.close();
        System.exit(0);
    }
}