// BOJ - 5568
// Problem Sheet - https://www.acmicpc.net/problem/5568

import java.util.*;
import java.io.*;

public class Main {
    static class Number {
        private final String value; // 만들어낸 수
        private final List<Integer> used; // 해당 수를 만드는 데 사용된 카드의 인덱스

        public Number(String value, List<Integer> used, int latestUsed) {
            this.value = value;
            this.used = used;
            this.used.add(latestUsed);
        }

        public String getValue() { return this.value; }
        public List<Integer> getUsed() { return this.used; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 카드의 수
        int k = Integer.parseInt(bf.readLine()); // 선택할 카드의 수
        String[] cards = new String[n];
        for(int i=0 ; i<n ; i++)
            cards[i] = bf.readLine();

        // 모든 카드에 대하여 BFS를 수행하며 다음을 반복함
        Set<String> numbers = new HashSet<>(); // 발생한 수의 Set
        for(int i=0 ; i<n ; i++)
            bfs(cards, numbers, i, k);
        System.out.println(numbers.size());

        bf.close();
        System.exit(0);
    }

    static void bfs(String[] cards, Set<String> numbers, int start, int usedCount) {
        Queue<Number> queue = new LinkedList<>(); // bfs를 위해 사용하는 queue

        queue.add(new Number(cards[start], new ArrayList<>(), start));
        while(!queue.isEmpty()) {
            String curValue = queue.peek().getValue();
            int curUsed = queue.peek().getUsed().size();

            if(curUsed == usedCount)
                numbers.add(curValue);
            if(curUsed > usedCount) break;

            for(int i=0 ; i<cards.length ; i++) {
                List<Integer> used = new ArrayList<>();
                used.addAll(queue.peek().getUsed());
                if(!queue.peek().getUsed().contains(i))
                    queue.add(new Number(curValue + cards[i], used, i));
            }

            queue.poll();
        }
    }
}