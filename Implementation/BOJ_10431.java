// BOJ - 10431
// Problem Sheet - https://www.acmicpc.net/problem/10431

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCase = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCase ; i++) {
            int numberOfMovement = 0;
            st = new StringTokenizer(bf.readLine());
            int testCaseIndex = Integer.parseInt(st.nextToken());
            int[] childrens = new int[20];
            for(int j=0 ; j<20 ; j++) {
                childrens[j] = Integer.parseInt(st.nextToken());
                numberOfMovement += getTallerCount(childrens, j, childrens[j]);
            }
            sb.append(testCaseIndex)
                    .append(" ")
                    .append(numberOfMovement)
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getTallerCount(int[] childrens, int size, int height) {
        int bigCount = 0;
        for(int i=0 ; i<size ; i++) {
            if(childrens[i] > height) {
                bigCount++;
            }
        }
        return bigCount;
    }
}