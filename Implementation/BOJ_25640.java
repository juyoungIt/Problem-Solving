// BOJ - 25640
// Problem Sheet - https://www.acmicpc.net/problem/25640

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i=0 ; i<n ; i++) {
            String candidate = br.readLine();
            if (candidate.equals(target)) count++;
        }
        System.out.println(count);
        br.close();
    }
}
