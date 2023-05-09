// BOJ - 15829
// Problem Sheet - https://www.acmicpc.net/problem/15829

import java.io.*;
import java.math.BigInteger;

public class Main {

    private static final String R_IN_EXPR = "31";
    private static final String M_IN_EXPR = "1234567891";

    public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            int lengthOfData = Integer.parseInt(bf.readLine());
            String data = bf.readLine();
            BigInteger base = new BigInteger("0");
            for(int i=0 ; i<lengthOfData ; i++) {
                base = base.add(new BigInteger(Integer.toString(data.charAt(i)-'a'+1))
                        .multiply(new BigInteger(R_IN_EXPR).pow(i)));
            }
            base = base.mod(new BigInteger(M_IN_EXPR));

            System.out.println(base);

            bf.close();
            System.exit(0);
    }
}