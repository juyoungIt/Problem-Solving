// BOJ - 21771
// Problem Sheet - https://www.acmicpc.net/problem/21771

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int rg = Integer.parseInt(input[0]);
        int cg = Integer.parseInt(input[1]);
        int rp = Integer.parseInt(input[2]);
        int cp = Integer.parseInt(input[3]);

        int gCount = 0, pCount = 0;
        for (int i=0 ; i<r ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<c ; j++) {
                if (row.charAt(j) == 'P') pCount++;
                if (row.charAt(j) == 'G') gCount++;
            }
        }

        if (pCount < rp * cp) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }
}