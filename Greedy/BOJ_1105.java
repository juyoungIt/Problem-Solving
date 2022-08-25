// BOJ - 1105
// Problem Sheet - https://www.acmicpc.net/problem/1105

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int l = Integer.parseInt(st.nextToken()); // number L
        int r = Integer.parseInt(st.nextToken()); // number R
        int answer = 10; // 가장 적은 8의 갯수

        for(Integer i=l ; i<=r ; i++) {
            String tmp = i.toString();
            int count = 0; // 8의 갯수
            for(int j=0 ; j<tmp.length() ; j++) {
                if(tmp.charAt(j) == '8')
                    count++;
            }
            if(answer > count)
                answer = count;
            if(answer == 0) break;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}