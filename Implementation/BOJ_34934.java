// BOJ - 34934
// Problem Sheet - https://www.acmicpc.net/problem/34934

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int latest = 0;
        String answer = "";
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int created = Integer.parseInt(st.nextToken());
            if (latest < created) {
                answer = name;
                latest = created;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
