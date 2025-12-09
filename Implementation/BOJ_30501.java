// BOJ - 30501
// Problem Sheet - https://www.acmicpc.net/problem/30501

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] suspects = new String[n];
        for (int i=0 ; i<n ; i++) {
            suspects[i] = br.readLine();
        }
        br.close();
        for (String suspect : suspects) {
            for (int i=0 ; i<suspect.length() ; i++) {
                if (suspect.charAt(i) == 'S') {
                    System.out.println(suspect);
                    return;
                }
            }
        }
    }
}
