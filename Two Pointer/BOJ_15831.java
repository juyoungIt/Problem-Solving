// BOJ - 15831
// Problem Sheet - https://www.acmicpc.net/problem/15831

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        String section = bf.readLine();

        int numberOfBlack = 0;
        int numberOfWhite = 0;
        int nextIndex = 0;
        int maxDistance = 0;
        for(int i=0 ; i<N ; i++) {
            while(nextIndex < N) {
                if(numberOfBlack == B && section.charAt(nextIndex) == 'B') {
                    break;
                }
                if(section.charAt(nextIndex) == 'B') {
                    numberOfBlack++;
                } else {
                    numberOfWhite++;
                }
                nextIndex++;
            }
            if(numberOfWhite >= W) {
                maxDistance = Math.max(maxDistance, nextIndex - i);
            }
            if(section.charAt(i) == 'W') {
                numberOfWhite--;
            } else {
                numberOfBlack--;
            }
        }

        System.out.println(maxDistance);

        bf.close();
        System.exit(0);
    }
}