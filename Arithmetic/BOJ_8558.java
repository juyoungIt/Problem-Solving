// BOJ - 8558
// Problem Sheet - https://www.acmicpc.net/problem/8558

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 1;
        for (int i=1 ; i<=n ; i++) {
            answer = (answer * i) % 10;
        }
        System.out.println(answer);
        br.close();
    }
}