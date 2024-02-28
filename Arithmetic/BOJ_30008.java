// BOJ - 30008
// Problem Sheet - https://www.acmicpc.net/problem/30008

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++) {
            int rank = Integer.parseInt(st.nextToken());
            sb.append(getGrade(rank * 100 / n)).append(" ");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getGrade(int p) {
        if(p >= 0 && p <= 4) return 1;
        else if(p > 4 && p <= 11) return 2;
        else if(p > 11 && p <= 23) return 3;
        else if(p > 23 && p <= 40) return 4;
        else if(p > 40 && p <= 60) return 5;
        else if(p > 60 && p <= 77) return 6;
        else if(p > 77 && p <= 89) return 7;
        else if(p > 89 && p <= 96) return 8;
        else return 9;
    }
}