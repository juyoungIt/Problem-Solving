// BOJ - 25704
// Problem Sheet - https://www.acmicpc.net/problem/25704

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int result;

        if(n < 5) {
            result = p;
        } else if(n < 10) {
            result = getDiscountA(p);
        } else if(n < 15) {
            result = Math.min(getDiscountA(p), getDiscountB(p));
        } else if(n < 20) {
            result = Math.min(getDiscountA(p),
                    Math.min(getDiscountB(p), getDiscountC(p)));
        } else {
            result = Math.min(getDiscountA(p),
                    Math.min(getDiscountB(p),
                            Math.min(getDiscountC(p), getDiscountD(p))));
        }

        System.out.println(result);

        br.close();
        System.exit(0);
    }

    private static int getDiscountA(int price) {
        return Math.max(price - 500, 0);
    }

    private static int getDiscountB(int price) {
        return (int)(price * 0.9);
    }

    private static int getDiscountC(int price) {
        return Math.max(price - 2_000, 0);
    }

    private static int getDiscountD(int price) {
        return (int)(price * 0.75);
    }

}