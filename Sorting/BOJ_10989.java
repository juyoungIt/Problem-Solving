// BOJ - 10989
// Problem Sheet - https://www.acmicpc.net/problem/10989

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfElements = Integer.parseInt(bf.readLine());
        int[] counts = new int[10001];
        for(int i=0 ; i<numberOfElements ; i++) {
            counts[Integer.parseInt(bf.readLine())]++;
        }

        for(int i=1 ; i<=10000 ; i++) {
            if(counts[i] > 0) {
                for(int j=0 ; j<counts[i] ; j++) {
                    bw.append(Integer.toString(i)).append("\n");
                }
            }
        }

        bf.close();
        bw.flush();
        bw.close();
        System.exit(0);
    }
}