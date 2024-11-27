// BOJ - 30647
// Problem Sheet - https://www.acmicpc.net/problem/30647

import java.util.*;
import java.io.*;

public class Main {

    static class Participant implements Comparable<Participant> {
        private int rank;
        private final String name;
        private final int score;
        private final boolean isHidden;

        public Participant(String name, int score, boolean isHidden) {
            this.name = name;
            this.score = score;
            this.isHidden = isHidden;
        }

        public int getRank() { return this.rank; }
        public String getName() { return this.name; }
        public int getScore() { return this.score; }
        public boolean getIsHidden() { return this.isHidden; }
        public void setRank(int rank) { this.rank = rank; }

        @Override
        public int compareTo(Participant p) {
            if (this.score == p.getScore()) {
                return this.getName().compareTo(p.getName());
            }
            return p.getScore() - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Participant[] participants = new Participant[N];
        for (int i=0 ; i<N ; i++) {
            String[] input = br.readLine().split(",");
            String name = input[0].split(":")[1].substring(1, input[0].split(":")[1].length() - 1);
            int score = Integer.parseInt(input[1].split(":")[1]);
            boolean isHidden = input[2].split(":")[1].charAt(0) == '1';
            participants[i] = new Participant(name, score, isHidden);
        }
        Arrays.sort(participants);

        int curRank = 1;
        int rankCount = 0;
        int prevScore = participants[0].getScore();
        for (int i=0 ; i<N ; i++) {
            if (participants[i].getScore() == prevScore) {
                rankCount++;
            } else {
                curRank += rankCount;
                rankCount = 1;
            }
            participants[i].setRank(curRank);
            prevScore = participants[i].getScore();
        }

        for (Participant participant : participants) {
            if (participant.getIsHidden()) continue;
            sb.append(
                    String.format(
                            "%d %s %d\n",
                            participant.getRank(),
                            participant.getName(),
                            participant.getScore()
                    )
            );
        }

        System.out.println(sb);
        br.close();
    }
}