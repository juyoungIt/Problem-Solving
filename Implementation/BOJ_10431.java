// BOJ - 10431
// Problem Sheet - https://www.acmicpc.net/problem/10431

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCase = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCase ; i++) {
            int numberOfMovement = 0;
            st = new StringTokenizer(bf.readLine());
            int testCaseIndex = Integer.parseInt(st.nextToken());
            int[] childrens = new int[20];
            for(int j=0 ; j<20 ; j++) {
                int height = Integer.parseInt(st.nextToken());
                int index = findIndex(childrens, j, height);
                if(index < j) {
                    numberOfMovement += j-index;
                    for(int k=j ; k>index ; k--) {
                        childrens[k] = childrens[k-1];
                    }
                }
                childrens[index] = height;
            }
            sb.append(testCaseIndex)
                    .append(" ")
                    .append(numberOfMovement)
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int findIndex(int[] childrens, int size, int height) {
        for(int i=0 ; i<size ; i++) {
            if(childrens[i] > height) {
                return i;
            }
        }
        return size;
    }
}