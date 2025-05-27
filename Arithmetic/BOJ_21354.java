// BOJ - 21354
// Problem Sheet - https://www.acmicpc.net/problem/21354

import java.io.*;

public class Main {

    private static final String AXEL = "Axel";
    private static final String PETRA = "Petra";
    private static final String LIKA = "lika";
    private static final int PRICE_OF_APPLE = 7;
    private static final int PRICE_OF_PEAR = 13;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        int a = Integer.parseInt(row[0]);
        int p = Integer.parseInt(row[1]);
        int priceA = PRICE_OF_APPLE * a;
        int priceP = PRICE_OF_PEAR * p;
        if (priceA == priceP) {
            System.out.println(LIKA);
        } else if (priceA < priceP) {
            System.out.println(PETRA);
        } else {
            System.out.println(AXEL);
        }
        br.close();
    }
}