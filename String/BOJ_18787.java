// BOJ - 18787
// Problem Sheet - https://www.acmicpc.net/problem/18787

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();
        int reverseCount = 0;
        boolean isDiffRange = false;
        for (int i=0 ; i<n ; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!isDiffRange) isDiffRange = true;
            } else {
                if (isDiffRange) {
                    reverseCount++;
                    isDiffRange = false;
                }
            }
        }
        System.out.println(reverseCount);
        br.close();
    }
}