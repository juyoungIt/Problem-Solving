// BOJ - 2711
// Problem Sheet - https://www.acmicpc.net/problem/2711

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        StringBuilder temp = new StringBuilder();
        for(int i=0 ; i<numberOfTestCases ; i++) {
            st = new StringTokenizer(bf.readLine());
            int errorIndex = Integer.parseInt(st.nextToken());
            char[] letters = st.nextToken().toCharArray();
            for(int j=0 ; j<letters.length ; j++) {
                if(j != errorIndex-1) {
                    temp.append(letters[j]);
                }
            }
            sb.append(temp).append("\n");
            temp.setLength(0);
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}