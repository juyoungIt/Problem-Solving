// BOJ - 9086
// Problem Sheet - https://www.acmicpc.net/problem/9086

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            String input = bf.readLine();
            sb.append(input.charAt(0))
                    .append(input.charAt(input.length()-1))
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}