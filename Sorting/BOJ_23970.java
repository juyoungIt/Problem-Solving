// BOJ - 23970
// Problem Sheet - https://www.acmicpc.net/problem/23970

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean isValid = false;

        int sizeOfArray = Integer.parseInt(bf.readLine());
        int[] origin = new int[sizeOfArray];
        int[] target = new int[sizeOfArray];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<sizeOfArray ; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<sizeOfArray ; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        if(Arrays.equals(origin, target)) {
            isValid = true;
        }

        for(int i=0 ; i<sizeOfArray ; i++) {
            if(isValid) {
                break;
            }
            if(i > 0 && origin[sizeOfArray-i] != target[sizeOfArray-i]) {
                break;
            }
            for(int j=0 ; j<sizeOfArray-i-1 ; j++) {
                if(origin[j] > origin[j+1]) {
                    int tmp = origin[j];
                    origin[j] = origin[j+1];
                    origin[j+1] = tmp;
                    if(origin[sizeOfArray-i-1] == target[sizeOfArray-i-1] && Arrays.equals(origin, target)) {
                        isValid = true;
                        break;
                    }
                }
            }
        }

        System.out.println(isValid ? 1 : 0);

        bf.close();
        System.exit(0);
    }
}