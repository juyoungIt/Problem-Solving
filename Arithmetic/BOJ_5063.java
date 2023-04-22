// BOJ - 5063
// Problem Sheet - https://www.acmicpc.net/problem/5063

import java.util.*;
import java.io.*;

public class Main {

    private static final String SHOULD_HAVE_ADVERTISE = "advertise";
    private static final String SHOULD_NOT_HAVE_ADVERTISE = "do not advertise";
    private static final String DOES_NOT_MATTER = "does not matter";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            st = new StringTokenizer(bf.readLine());
            int benefitNotAdvertise = Integer.parseInt(st.nextToken());
            int benefitWhenAdvertise = Integer.parseInt(st.nextToken());
            int advertisePrice = Integer.parseInt(st.nextToken());

            if(benefitNotAdvertise > benefitWhenAdvertise-advertisePrice) {
                sb.append(SHOULD_NOT_HAVE_ADVERTISE).append("\n");
            } else if(benefitNotAdvertise < benefitWhenAdvertise-advertisePrice) {
                sb.append(SHOULD_HAVE_ADVERTISE).append("\n");
            } else {
                sb.append(DOES_NOT_MATTER).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}