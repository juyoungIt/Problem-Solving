// BOJ - 34824
// Problem Sheet - https://www.acmicpc.net/problem/34824

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String name = br.readLine();
            if (name.equals("korea")) {
                System.out.println("Yonsei Lost...");
                return;
            }
            if (name.equals("yonsei")) {
                System.out.println("Yonsei Won!");
                return;
            }
        }
        br.close();
    }
}
