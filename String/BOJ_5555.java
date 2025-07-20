// BOJ - 5555
// Problem Sheet - https://www.acmicpc.net/problem/5555

import java.io.*;

public class Main {

    static String str;
    static int n;
    static String[] rings;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        n = Integer.parseInt(br.readLine());
        rings = new String[n];
        for (int i=0 ; i<n ; i++) {
            rings[i] = br.readLine();
        }
        br.close();
    }

    static int solve() {
        int count = 0;
        for (String ring : rings) {
            if ((ring + ring).contains(str)) {
                count++;
            }
        }
        return count;
    }

}