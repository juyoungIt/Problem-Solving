// BOJ - 1120
// Problem Sheet - https://www.acmicpc.net/problem/1120

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String wordA = st.nextToken();
        String wordB = st.nextToken();
        int minDifference = wordB.length();
        int lengthDifference = wordB.length() - wordA.length();

        if(wordA.length() == wordB.length()) {
            minDifference = getDifference(wordA, wordB, 0);
        } else {
            for(int i=0 ; i<=lengthDifference ; i++) {
                int currentDifference = getDifference(wordA, wordB, i);
                if(minDifference > currentDifference) {
                    minDifference = currentDifference;
                }
            }
        }

        System.out.println(minDifference);

        bf.close();
        System.exit(0);
    }

    private static int getDifference(String wordA, String wordB, int indexDiff) {
        int differenceCount = 0;
        for(int i=0 ; i<wordA.length() ; i++) {
            if(wordA.charAt(i) != wordB.charAt(i+indexDiff)) {
                differenceCount++;
            }
        }
        return differenceCount;
    }
}