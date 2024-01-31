// BOJ - 2997
// Problem Sheet - https://www.acmicpc.net/problem/2997

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] elements = new int[3];
        for(int i=0 ; i<3 ; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(elements);

        if(elements[1] - elements[0] == elements[2] - elements[1]) {
            System.out.println(elements[2] + elements[1] - elements[0]);
        } else if(elements[1] - elements[0] > elements[2] - elements[1]) {
            System.out.println(elements[0] + elements[2] - elements[1]);
        } else {
            System.out.println(elements[1] * 2 - elements[0]);
        }

        br.close();
        System.exit(0);
    }
}