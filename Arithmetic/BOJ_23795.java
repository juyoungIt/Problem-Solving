// BOJ - 23795
// Problem Sheet - https://www.acmicpc.net/problem/23795

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalLose = 0;
        while(true) {
            int lose = Integer.parseInt(bf.readLine());
            if(lose == -1) break;
            totalLose += lose;
        }

        System.out.println(totalLose);

        bf.close();
        System.exit(0);
    }
}