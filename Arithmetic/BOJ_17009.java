// BOJ - 17009
// Problem Sheet - https://www.acmicpc.net/problem/17009

import java.io.*;

public class Main {

    enum WINNING_CODE {
        A, B, T
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] pointCntOfTeamA = new int[3];
        int[] pointCntOfTeamB = new int[3];

        for(int i=0 ; i<3 ; i++) pointCntOfTeamA[i] = Integer.parseInt(br.readLine());
        for(int i=0 ; i<3 ; i++) pointCntOfTeamB[i] = Integer.parseInt(br.readLine());

        int scoreOfTeamA = getScore(pointCntOfTeamA);
        int scoreOfTeamB = getScore(pointCntOfTeamB);

        if(scoreOfTeamA > scoreOfTeamB) System.out.println(WINNING_CODE.A);
        else if(scoreOfTeamA < scoreOfTeamB) System.out.println(WINNING_CODE.B);
        else System.out.println(WINNING_CODE.T);

        br.close();
        System.exit(0);
    }

    private static int getScore(int[] scores) {
        return 3 * scores[0] + 2 * scores[1] + scores[2];
    }
}