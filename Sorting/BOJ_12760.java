// BOJ - 12760
// Problem Sheet - https://www.acmicpc.net/problem/12760

import java.util.*;
import java.io.*;

public class Main {

    static class CardInfo implements Comparable<CardInfo> {
        private final int playerIndex;
        private final int value;

        public CardInfo(int playerIndex, int value) {
            this.playerIndex = playerIndex;
            this.value = value;
        }

        public int getPlayerIndex() { return this.playerIndex; }
        public int getValue() { return this.value; }

        @Override
        public int compareTo(CardInfo o) {
            return o.getValue() - this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<PriorityQueue<CardInfo>> users = new ArrayList<>();
        users.add(null);
        for (int i=1 ; i<=n ; i++) {
            users.add(new PriorityQueue<>());
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<m ; j++) {
                users.get(i).add(new CardInfo(i, Integer.parseInt(st.nextToken())));
            }
        }

        int maxScore = 0;
        int[] scores = new int[n + 1];
        PriorityQueue<CardInfo> winnerQueue = new PriorityQueue<>();
        for (int i=0 ; i<m ; i++) {
            for (int j=1 ; j<=n ; j++) {
                winnerQueue.add(users.get(j).poll());
            }
            int maxValue = winnerQueue.peek().getValue();
            while (!winnerQueue.isEmpty()) {
                if (winnerQueue.peek().getValue() < maxValue) {
                    break;
                }
                scores[winnerQueue.peek().getPlayerIndex()]++;
                maxScore= Math.max(maxScore, scores[winnerQueue.peek().getPlayerIndex()]);
                winnerQueue.poll();
            }
            winnerQueue.clear();
        }

        for (int i=1 ; i<=n ; i++) {
            if (scores[i] == maxScore) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}