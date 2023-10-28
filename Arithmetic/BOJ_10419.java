// BOJ - 10419
// Problem Sheet - https://www.acmicpc.net/problem/10419

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<t ; i++) {
            int d = Integer.parseInt(bf.readLine());
            sb.append(getMaxLateTime(d)).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getMaxLateTime(int d) {
        int lateTime = 0;
        while(true) {
            int requiredTime = getRequiredTime(lateTime);
            if(requiredTime > d) {
                break;
            }
            lateTime++;
        }
        return lateTime - 1;
    }

    private static int getRequiredTime(int t) {
        return t * (t + 1);
    }
}