// BOJ - 14531
// Problem Sheet - https://www.acmicpc.net/problem/14531

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        String[] spotties = new String[n];
        for (int i=0 ; i<n ; i++) {
            spotties[i] = br.readLine();
        }
        String[] plain = new String[n];
        for (int i=0 ; i<n ; i++) {
            plain[i] = br.readLine();
        }

        int count = 0;
        for (int i=0 ; i<m ; i++) {
            Set<Character> spottySet = new HashSet<>();
            for (int j=0 ; j<n ; j++) {
                spottySet.add(spotties[j].charAt(i));
            }
            boolean isValid = true;
            for (int j=0 ; j<n ; j++) {
                if (spottySet.contains(plain[j].charAt(i))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) count++;
        }

        System.out.println(count);
        br.close();
    }
}