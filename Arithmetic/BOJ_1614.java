// BOJ - 1614
// Problem Sheet - https://www.acmicpc.net/problem/1614

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int injured = Integer.parseInt(br.readLine());
        int availableCnt = Integer.parseInt(br.readLine());
        long totalCnt = 0;

        if(injured == 1) {
            totalCnt += 8L * availableCnt;
        } else if(injured == 5) {
            totalCnt += 8L * availableCnt + 4;
        } else {
            if(availableCnt % 2 == 0) {
                totalCnt += injured - 1;
            } else {
                totalCnt += 5 - injured;
            }
            totalCnt += 4L * availableCnt;
        }

        System.out.println(totalCnt);

        br.close();
        System.exit(0);
    }
}