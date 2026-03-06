// BOJ - 17598
// Problem Sheet - https://www.acmicpc.net/problem/17598

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countA = 0, countB = 0;
        for (int i=0 ; i<9 ; i++) {
            String s = br.readLine();
            if (s.equals("Lion")) countA++;
            else countB++;
        }
        System.out.println(countA > countB ? "Lion" : "Tiger");
        br.close();
    }
}
