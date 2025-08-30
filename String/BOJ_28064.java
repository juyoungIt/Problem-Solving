// BOJ - 28064
// Problem Sheet - https://www.acmicpc.net/problem/28064

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        for (int i=0 ; i<n ; i++) {
            names[i] = br.readLine();
        }

        int pairCount = 0;
        for (int i=0 ; i<n-1 ; i++) {
            for (int j=i+1 ; j<n ; j++) {
                if (!isValidPair(names[i], names[j])) continue;
                pairCount++;
            }
        }

        System.out.println(pairCount);
        br.close();
    }

    private static boolean isValidPair(String n1, String n2) {
        for (int i=1 ; i<=Math.min(n1.length(), n2.length()) ; i++) {
            if (n1.substring(0, i).equals(n2.substring(n2.length() - i))
                    || n2.substring(0, i).equals(n1.substring(n1.length() - i))) {
                return true;
            }
        }
        return false;
    }
}