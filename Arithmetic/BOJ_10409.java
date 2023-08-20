// BOJ - 10409
// Problem Sheet - https://www.acmicpc.net/problem/10409

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int done = 0;
        for(int i=0 ; i<n ; i++) {
            int taskTime = Integer.parseInt(st.nextToken());
            if(t - taskTime < 0) {
                break;
            }
            done++;
            t -= taskTime;
        }

        System.out.println(done);

        bf.close();
        System.exit(0);
    }
}