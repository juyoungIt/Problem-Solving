// BOJ - 10102
// Problem Sheet - https://www.acmicpc.net/problem/10102

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] judgeScore = new int[2];

        int numberOfJudges = Integer.parseInt(bf.readLine());
        String judges = bf.readLine();
        for(int i=0 ; i<numberOfJudges ; i++) {
            if(judges.charAt(i) == 'A') {
                judgeScore[0]++;
            } else if(judges.charAt(i) == 'B') {
                judgeScore[1]++;
            } else {
                throw new IllegalArgumentException("Illegal Judgement");
            }
        }

        if(judgeScore[0] > judgeScore[1]) {
            System.out.println("A");
        } else if(judgeScore[0] < judgeScore[1]) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }

        bf.close();
        System.exit(0);
    }
}