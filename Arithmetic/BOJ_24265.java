// BOJ - 24265
// Problem Sheet - https://www.acmicpc.net/problem/24265

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        long runningCount = 0;
        for(int i=1 ; i<n ; i++) {
            runningCount += i;
        }

        System.out.println(runningCount);
        System.out.println(2);

        bf.close();
        System.exit(0);
    }
}