// BOJ - 1652
// Problem Sheet - https://www.acmicpc.net/problem/1652

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] results = new int[2];

        int sizeOfRoom = Integer.parseInt(bf.readLine());
        char[][] room = new char[sizeOfRoom][sizeOfRoom];
        for(int i=0 ; i<sizeOfRoom ; i++) {
            char[] row = bf.readLine().toCharArray();
            for(int j=0 ; j<row.length ; j++) {
                room[i][j] = row[j];
            }
        }

        for(int i=0 ; i<sizeOfRoom ; i++) {
            int capable = 0;
            boolean isSequence = false;
            for(int j=0 ; j<sizeOfRoom ; j++) {
                if(room[i][j] == '.') {
                    capable++;
                } else {
                    capable = 0;
                    isSequence = false;
                }
                if(!isSequence && capable >= 2) {
                    isSequence = true;
                    results[0]++;
                }
            }
            capable = 0;
            isSequence = false;
            for(int j=0 ; j<sizeOfRoom ; j++) {
                if(room[j][i] == '.') {
                    capable++;
                } else {
                    capable = 0;
                    isSequence = false;
                }
                if(!isSequence && capable >= 2) {
                    isSequence = true;
                    results[1]++;
                }
            }
        }

        System.out.println(results[0] + " " + results[1]);

        bf.close();
        System.exit(0);
    }
}