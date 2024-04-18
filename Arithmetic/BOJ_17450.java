// BOJ - 17450
// Problem Sheet - https://www.acmicpc.net/problem/17450

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxIndex = 0;
        double maxCostEffective = 0;
        for (int i=0 ; i<3 ; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            double costEffective = (double) (weight * 10) / useCoupon(price * 10);
            if (maxCostEffective < costEffective) {
                maxIndex = i;
                maxCostEffective = costEffective;
            }
        }

        System.out.println(getBestProduct(maxIndex));

        br.close();
        System.exit(0);
    }

    private static int useCoupon(int price) {
        if (price >= 5_000) {
            price -= 500;
        }
        return price;
    }
    private static char getBestProduct(int index) {
        if (index == 0) {
            return 'S';
        } else if (index == 1) {
            return 'N';
        } else {
            return 'U';
        }
    }
}