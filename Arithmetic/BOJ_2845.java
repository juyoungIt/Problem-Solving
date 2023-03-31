// BOJ - 2845
// Problem Sheet - https://www.acmicpc.net/problem/2845

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int numberOfParticipants = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<5 ; i++) {
            sb.append(Integer.parseInt(st.nextToken()) - numberOfParticipants).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}