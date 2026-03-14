// BOJ - 30957
// Problem Sheet - https://www.acmicpc.net/problem/30957

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int[] counts = new int[3];
        int maxCount = 0;
        for (int i=0 ; i<n ; i++) {
            char c = input.charAt(i);
            counts[getIndex(c)]++;
            maxCount = Math.max(maxCount, counts[getIndex(c)]);
        }
        if (counts[0] == counts[1] && counts[1] == counts[2]) {
            System.out.println("SCU");
        } else {
            for (int i=0 ; i<3 ; i++) {
                if (counts[i] < maxCount) continue;
                System.out.print(getChar(i));
            }
        }
        br.close();
    }

    private static int getIndex(char c) {
        if (c == 'B') return 0;
        else if (c == 'S') return 1;
        else if (c == 'A') return 2;
        else throw new IllegalArgumentException("invalid character...");
    }

    private static char getChar(int i) {
        if (i == 0) return 'B';
        else if (i == 1) return 'S';
        else if (i == 2) return 'A';
        else throw new IllegalArgumentException("invalid index...");
    }
}
