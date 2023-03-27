// BOJ - 10886
// Problem Sheet - https://www.acmicpc.net/problem/10886

import java.util.*;
import java.io.*;

public class Main {

    private static final String CUTE = "Junhee is cute!";
    private static final String NOT_CUTE = "Junhee is not cute!";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] surveyCount = new int[2];

        int numberOfSurvey = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfSurvey ; i++) {
            surveyCount[Integer.parseInt(bf.readLine())]++;
        }

        System.out.println((surveyCount[0] < surveyCount[1]) ? CUTE : NOT_CUTE);

        bf.close();
        System.exit(0);
    }
}