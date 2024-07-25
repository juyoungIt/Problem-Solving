// BOJ - 24817
// Problem Sheet - https://www.acmicpc.net/problem/24817

import java.io.*;
import java.util.*;

public class Main {

    private static final String WINNER_MESSAGE_FORMAT = "%s wins!";
    private static final String NO_WINNER_MESSAGE_FORMAT = "No winner!";

    static class Participant {
        private final String name;
        private int score;
        private int reachedSeq;

        public Participant(String name, int score) {
            this.name = name;
            this.score = score;
            this.reachedSeq = 100_001;
        }

        public String getName() { return this.name; }
        public int getScore() { return this.score; }
        public int getReachedSeq() { return this.reachedSeq; }
        public void addScore(int increment) { this.score += increment; }
        public void setReachedSeq(int reachedSeq) { this.reachedSeq = reachedSeq; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Participant> countMapper = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            String name = br.readLine();
            countMapper.put(name, new Participant(name, 0));
        }

        int reachedCount = 0;
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            countMapper.get(name).addScore(score);
            if (countMapper.get(name).getReachedSeq() > 100_000
                    && countMapper.get(name).getScore() >= p) {
                countMapper.get(name).setReachedSeq(++reachedCount);
            }
        }

        List<Participant> participants = new ArrayList<>(countMapper.values());
        participants.sort(Comparator.comparingInt(Participant::getReachedSeq));

        if (reachedCount > 0) {
            for (int i=0 ; i<reachedCount ; i++) {
                sb.append(String.format(WINNER_MESSAGE_FORMAT, participants.get(i).getName())).append("\n");
            }
        } else {
            sb.append(NO_WINNER_MESSAGE_FORMAT);
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}