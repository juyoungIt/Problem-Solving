// BOJ - 1100
// Problem Sheet - https://www.acmicpc.net/problem/1100

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberOfWhitePiece = 0;

        for(int i=0 ; i<8 ; i++) {
            String row = bf.readLine();
            for(int j=i%2 ; j<8 ; j+=2) {
                if(row.charAt(j) == 'F') {
                    numberOfWhitePiece++;
                }
            }
        }

        System.out.println(numberOfWhitePiece);

        bf.close();
        System.exit(0);
    }
}