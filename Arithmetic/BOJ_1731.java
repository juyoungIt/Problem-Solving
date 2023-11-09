// BOJ - 1731
// Problem Sheet - https://www.acmicpc.net/problem/1731

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] elements = new int[n];
        for(int i=0 ; i<n ; i++) {
            elements[i] = Integer.parseInt(bf.readLine());
        }

        boolean isArithmeticSeq = false;
        int diffA = elements[1] - elements[0];
        int diffB = elements[1] / elements[0];
        for(int i=2 ; i<n ; i++) {
            if(diffA == elements[i] - elements[i-1]) {
                isArithmeticSeq = true;
                break;
            }
        }

        System.out.println(isArithmeticSeq ? elements[n-1] + diffA : elements[n-1] * diffB);

        bf.close();
        System.exit(0);
    }
}