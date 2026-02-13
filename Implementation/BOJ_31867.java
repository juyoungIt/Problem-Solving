// BOJ - 31867
// Problem Sheet - https://www.acmicpc.net/problem/31867

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String k = br.readLine();
        int oddCount = 0, evenCount = 0;
        for (int i=0 ; i<n ; i++) {
            char d = k.charAt(i);
            if (Integer.parseInt(d + "") % 2 == 0) evenCount++;
            else oddCount++;
        }
        if (oddCount < evenCount) System.out.println(0);
        else if (oddCount > evenCount) System.out.println(1);
        else System.out.println(-1);
        br.close();
    }
}