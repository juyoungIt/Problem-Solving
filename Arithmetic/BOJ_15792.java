// BOJ - 15792
// Problem Sheet - https://www.acmicpc.net/problem/15792

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigDecimal a = new BigDecimal(st.nextToken());
        BigDecimal b = new BigDecimal(st.nextToken());

        System.out.println(a.divide(b, 2000, RoundingMode.HALF_UP));

        br.close();
        System.exit(0);
    }
}