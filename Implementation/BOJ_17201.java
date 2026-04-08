// BOJ - 17201
// Problem Sheet - https://www.acmicpc.net/problem/17201

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String magnet = br.readLine();
        boolean isConnected = true;
        for (int i=1 ; i<2*n-1 ; i+=2) {
            if (magnet.charAt(i) == magnet.charAt(i + 1)) {
                isConnected = false;
                break;
            }
        }
        System.out.println(isConnected ? "Yes" : "No");
        br.close();
    }
}