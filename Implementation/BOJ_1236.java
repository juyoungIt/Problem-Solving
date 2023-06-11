// BOJ - 1236
// Problem Sheet - https://www.acmicpc.net/problem/1236

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int widthResult = 0;
        int heightResult = 0;

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        boolean[] widthStatus = new boolean[width];
        boolean[] heightStatus = new boolean[height];
        for(int i=0 ; i<height ; i++) {
            String row = bf.readLine();
            for(int j=0 ; j<row.length() ; j++) {
                if(row.charAt(j) == 'X') {
                    widthStatus[j] = true;
                    heightStatus[i] = true;
                }
            }
        }

        for(boolean status : widthStatus) {
            if(!status) {
                widthResult++;
            }
        }
        for(boolean status : heightStatus) {
            if(!status) {
                heightResult++;
            }
        }

        System.out.println(Math.max(widthResult, heightResult));

        bf.close();
        System.exit(0);
    }
}