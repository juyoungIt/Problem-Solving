// BOJ - 31925
// Problem Sheet - https://www.acmicpc.net/problem/31925

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Participant {
        String name;
        boolean isStudent;
        boolean isICPCWinner;
        int shakeRank;
        int apcRank;

        public Participant(String name, boolean isStudent, boolean isICPCWinner, int shakeRank, int apcRank) {
            this.name = name;
            this.isStudent = isStudent;
            this.isICPCWinner = isICPCWinner;
            this.shakeRank = shakeRank;
            this.apcRank = apcRank;
        }
    }

    static int n;
    static Participant[] participants;
    static final String STUDENT = "jaehak";
    static final String ICPC_WINNER = "winner";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        participants = new Participant[n];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            String name = row[0];
            boolean isStudent = row[1].equals(STUDENT);
            boolean isICPCWinner = row[2].equals(ICPC_WINNER);
            int shakeRank = Integer.parseInt(row[3]);
            int apcRank = Integer.parseInt(row[4]);
            participants[i] = new Participant(name, isStudent, isICPCWinner, shakeRank, apcRank);
        }
        br.close();
    }

    static String solve() {
        StringBuilder sb = new StringBuilder();
        List<Participant> winners = Arrays.stream(participants)
                .filter(p -> p.isStudent)
                .filter(p -> !p.isICPCWinner)
                .filter(p -> p.shakeRank == -1 || p.shakeRank > 3)
                .sorted(Comparator.comparingInt(p -> p.apcRank))
                .limit(10)
                .collect(Collectors.toList());
        sb.append(winners.size()).append("\n");
        winners.sort(Comparator.comparing(w -> w.name));
        winners.forEach(w -> sb.append(w.name).append("\n"));
        return sb.toString();
    }

}