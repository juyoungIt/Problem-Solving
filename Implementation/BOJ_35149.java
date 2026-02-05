// BOJ - 35149
// Problem Sheet - https://www.acmicpc.net/problem/35149

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int empty = 0;
        int wall = 0;
        int oneDirVirus = 0;
        int allDirVirus = 0;
        int vaccine = 0;
        int start = 0;
        int end = 0;
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<m ; j++) {
                if (row.charAt(j) == '.') empty++;
                else if (row.charAt(j) == '#') wall++;
                else if (row.charAt(j) == 'U' || row.charAt(j) == 'D' || row.charAt(j) == 'L' || row.charAt(j) == 'R') oneDirVirus++;
                else if (row.charAt(j) == 'A') allDirVirus++;
                else if (row.charAt(j) == 'V') vaccine++;
                else if (row.charAt(j) == 'S') start++;
                else if (row.charAt(j) == 'E') end++;
            }
        }

        if (wall <= 1 && oneDirVirus <= 1 && allDirVirus == 0 && vaccine == 0 && start == 1 && end == 1) {
            System.out.println(1);
        } else if (allDirVirus == 0 && vaccine == 0 && start == 1 && end == 1) {
            System.out.println(2);
        } else if (allDirVirus == 0 && start == 1 && end == 1) {
            System.out.println(3);
        } else if (start == 1 && end == 1) {
            System.out.println(4);
        } else {
            System.out.println(-1);
        }
        br.close();
    }
}
