// BOJ - 25193
// Problem Sheet - https://www.acmicpc.net/problem/25193

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cCount = 0;
        int oCount = 0;
        for (int i=0 ; i<n ; i++) {
            if (s.charAt(i) == 'C') cCount++;
            else oCount++;
        }
        System.out.println((cCount / (oCount + 1)) + ((cCount % (oCount + 1)) > 0 ? 1 : 0));
        br.close();
    }
}