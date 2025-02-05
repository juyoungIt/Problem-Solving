// BOJ - 14889
// Problem Sheet - https://www.acmicpc.net/problem/14889

import java.io.*;

public class Main {

    private static int N;
    private static int[][] S;
    private static int[] startTeam, linkTeam;
    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 1);
        System.out.println(minDiff);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N + 1][N + 1];
        for (int i=1 ; i<=N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=1 ; j<=N ; j++) {
                S[i][j] = Integer.parseInt(row[j - 1]);
            }
        }
        startTeam = new int[N / 2];
        linkTeam = new int[N / 2];
        br.close();
    }

    private static void solve(int count, int lastIndex) {
        if (count == N / 2) {
            getLinkTeam();
            int startTeamAbility = getTeamAbility(startTeam);
            int linkTeamAbility = getTeamAbility(linkTeam);
            minDiff = Math.min(minDiff, Math.abs(startTeamAbility - linkTeamAbility));
            return;
        }
        for (int i=lastIndex ; i<=N ; i++) {
            startTeam[count] = i;
            solve(count + 1, i + 1);
        }
    }

    private static int getTeamAbility(int[] team) {
        int teamAbility = 0;
        for (int i=0 ; i<N/2-1 ; i++) {
            for (int j=i+1 ; j<N/2 ; j++) {
                teamAbility += S[team[i]][team[j]];
                teamAbility += S[team[j]][team[i]];
            }
        }
        return teamAbility;
    }

    private static void getLinkTeam() {
        int linkIndex = 0, startIndex = 0;
        for (int i=1 ; i<=N ; i++) {
            if (startIndex >= N/2 || startTeam[startIndex] != i) {
                linkTeam[linkIndex++] = i;
            } else {
                startIndex++;
            }
        }
    }
}