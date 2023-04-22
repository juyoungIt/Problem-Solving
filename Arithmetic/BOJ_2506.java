// BOJ - 2506
// Problem Sheet - https://www.acmicpc.net/problem/2506

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalScore = 0;

        int numberOfProblems = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] grades = new int[numberOfProblems];
        for(int i=0 ; i<numberOfProblems ; i++) {
            grades[i] = Integer.parseInt(st.nextToken());
        }

        int currentScores = 1;
        for(int grade : grades) {
            if(grade == 1) {
                totalScore += currentScores++;
            } else {
                currentScores = 1;
            }
        }

        System.out.println(totalScore);

        bf.close();
        System.exit(0);
    }
}