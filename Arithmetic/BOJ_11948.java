// BOJ - 11948
// Problem Sheet - https://www.acmicpc.net/problem/11948

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] groupA = new int[4];
        int[] groupB = new int[2];

        int groupSum = 0;
        for(int i=0 ; i<4 ; i++) {
            groupA[i] = Integer.parseInt(bf.readLine());
            groupSum += groupA[i];
        }
        for(int i=0 ; i<2 ; i++) {
            groupB[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(groupA);
        Arrays.sort(groupB);

        System.out.println(groupSum - groupA[0] + Math.max(groupB[0], groupB[1]));

        bf.close();
        System.exit(0);
    }
}