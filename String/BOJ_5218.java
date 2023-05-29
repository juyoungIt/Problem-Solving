// BOJ - 5218
// Problem Sheet - https://www.acmicpc.net/problem/5218

import java.util.*;
import java.io.*;

public class Main {

    private static final String MESSAGE_FORMAT = "Distances:";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0 ; i<numberOfTestCases ; i++) {
            sb.append(MESSAGE_FORMAT).append(" ");
            st = new StringTokenizer(bf.readLine());
            String wordA = st.nextToken();
            String wordB = st.nextToken();
            for(int j=0 ; j<wordA.length() ; j++) {
                sb.append(getAlphaDistance(wordA.charAt(j), wordB.charAt(j)))
                        .append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getAlphaDistance(char alphaA, char alphaB) {
        int numericA = getNumericValue(alphaA);
        int numericB = getNumericValue(alphaB);
        if(numericA <= numericB) {
            return numericB - numericA;
        } else {
            return (numericB + 26) - numericA;
        }
    }

    private static int getNumericValue(char alpha) {
        return alpha - 'A' + 1;
    }
}