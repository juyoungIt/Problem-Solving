// BOJ - 25314
// Problem Sheet - https://www.acmicpc.net/problem/25314

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<N/4 ; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}