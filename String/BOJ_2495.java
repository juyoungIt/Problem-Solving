// BOJ - 2495
// Problem Sheet - https://www.acmicpc.net/problem/2495

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<3 ; i++) {
            sb.append(getContinuousLength(bf.readLine())).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getContinuousLength(String input) {
        int maxContinuousLength = 1;
        int currentContinuousLength = 1;
        for(int i=1 ; i<input.length() ; i++) {
            if(input.charAt(i-1) == input.charAt(i)) {
                currentContinuousLength++;
            } else {
                if(currentContinuousLength > maxContinuousLength) {
                    maxContinuousLength = currentContinuousLength;
                }
                currentContinuousLength = 1;
            }
        }
        if(currentContinuousLength > maxContinuousLength) {
            maxContinuousLength = currentContinuousLength;
        }
        return maxContinuousLength;
    }
}