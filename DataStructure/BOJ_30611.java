// BOJ - 30611
// Problem Sheet - https://www.acmicpc.net/problem/30611

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        Set<String> setA = new HashSet<>();
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<m ; i++) {
            setA.add(row[i]);
        }

        int n = Integer.parseInt(br.readLine());
        row = br.readLine().split(" ");
        boolean isAvailable = true;
        for (int i=0 ; i<n ; i++) {
            if (!setA.contains(row[i])) {
                isAvailable = false;
                break;
            }
        }

        System.out.println(isAvailable ? 1 : 0);
        br.close();
    }
}