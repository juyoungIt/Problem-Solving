// BOJ - 12787
// Problem Sheet - https://www.acmicpc.net/problem/12787

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] row = br.readLine().split(" ");
            int m = Integer.parseInt(row[0]);
            String n = row[1];
            sb.append(convert(m, n)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static String convert(int m, String n) {
        if (m == 1) return ip8ToDecimal(n);
        else return decimalToIp8(n);
    }

    private static String ip8ToDecimal(String n) {
        String[] parts = n.split("\\.");
        StringBuilder buffer = new StringBuilder();
        for (String part : parts) {
            buffer.append(
                    String.format(
                            "%8s",
                            Integer.toBinaryString(Integer.parseInt(part))
                    ).replace(' ', '0')
            );
        }
        BigInteger result = new BigInteger(buffer.toString(), 2);
        return result.toString();
    }

    private static String decimalToIp8(String n) {
        int[] parts = new int[8];
        String bi = String.format("%64s", new BigInteger(n).toString(2)).replace(' ', '0');
        for (int i=0 ; i<bi.length() ; i+=8) {
            String part = bi.substring(i, i+8);
            parts[i / 8] = Integer.parseInt(part, 2);
        }
        StringJoiner sj = new StringJoiner(".");
        for (int part : parts) sj.add(Integer.toString(part));
        return sj.toString();
    }
}