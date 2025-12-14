// BOJ - 31822
// Problem Sheet - https://www.acmicpc.net/problem/31822

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetCode = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i=0 ; i<n ; i++) {
            String code = br.readLine();
            if (targetCode.substring(0, 5).equals(code.substring(0, 5))) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}
