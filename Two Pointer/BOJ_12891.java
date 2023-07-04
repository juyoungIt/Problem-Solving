// BOJ - 12891
// Problem Sheet - https://www.acmicpc.net/problem/12891

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] arr = bf.readLine().toCharArray();
        int[] baseCount = new int[4];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<4 ; i++) {
            baseCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] curCount = new int[4];
        int rightIndex = 0;
        int validCount = 0;
        curCount[getIndex(arr[0])]++;
        for(int i=0 ; i<S ; i++) {
            while(rightIndex - i + 1 < P && rightIndex < S-1) {
                curCount[getIndex(arr[++rightIndex])]++;
            }
            if(rightIndex - i + 1 == P && isValid(curCount, baseCount)) {
                validCount++;
            }
            curCount[getIndex(arr[i])]--;
        }

        System.out.println(validCount);

        bf.close();
        System.exit(0);
    }

    private static int getIndex(char code) {
        if(code == 'A') {
            return 0;
        } else if(code == 'C') {
            return 1;
        } else if(code == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

    private static boolean isValid(int[] curCount, int[] baseCount) {
        boolean result = true;
        for(int i=0 ; i<4 ; i++) {
            if(curCount[i] < baseCount[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}