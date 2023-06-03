// BOJ - 11328
// Problem Sheet - https://www.acmicpc.net/problem/11328

import java.util.*;
import java.io.*;

public class Main {

    enum Message {
        Possible, Impossible
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        String strA, strB;
        int[] strACount = new int[26];
        int[] strBCount = new int[26];

        for(int i=0 ; i<numberOfTestCases ; i++) {
            st = new StringTokenizer(bf.readLine());
            strA = st.nextToken();
            strB = st.nextToken();
            if(strA.length() != strB.length()) {
                sb.append(Message.Impossible).append("\n");
            } else {
                for(int j=0 ; j<strA.length() ; j++) {
                    strACount[strA.charAt(j)-'a']++;
                    strBCount[strB.charAt(j)-'a']++;
                }
                if(Arrays.equals(strACount, strBCount)) {
                    sb.append(Message.Possible).append("\n");
                } else {
                    sb.append(Message.Impossible).append("\n");
                }
            }
            Arrays.fill(strACount, 0);
            Arrays.fill(strBCount, 0);
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}