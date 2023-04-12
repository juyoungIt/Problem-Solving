// BOJ - 5522
// Problem Sheet - https://www.acmicpc.net/problem/5522

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sumOfScores = 0;
        for(int i=0 ; i<5 ; i++) {
            sumOfScores += Integer.parseInt(bf.readLine());
        }
        System.out.println(sumOfScores);

        bf.close();
        System.exit(0);
    }
}