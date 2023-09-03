// BOJ - 11652
// Problem Sheet - https://www.acmicpc.net/problem/11652

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        long[] arr = new long[N];
        for(int i=0 ; i<N ; i++) {
            arr[i] = Long.parseLong(bf.readLine());
        }
        Arrays.sort(arr);

        int curCount = 1;
        long mostFrequentNumber = arr[0];
        int mostFrequentNumberCount = 1;
        for(int i=1 ; i<N ; i++) {
            if(arr[i-1] == arr[i]) {
                curCount++;
            } else {
                if(curCount > mostFrequentNumberCount) {
                    mostFrequentNumber = arr[i-1];
                    mostFrequentNumberCount = curCount;
                }
                curCount = 1;
            }
        }
        if(curCount > mostFrequentNumberCount) {
            mostFrequentNumber = arr[N-1];
        }

        System.out.println(mostFrequentNumber);

        bf.close();
        System.exit(0);
    }
}