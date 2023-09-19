// BOJ - 15720
// Problem Sheet - https://www.acmicpc.net/problem/15720

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int maxCnt = Math.max(B, Math.max(C, D));
        int minCnt = Math.min(B, Math.min(C, D));

        Integer[] bugger = new Integer[maxCnt];
        Integer[] side = new Integer[maxCnt];
        Integer[] beverage = new Integer[maxCnt];
        Arrays.fill(bugger, 0);
        Arrays.fill(side, 0);
        Arrays.fill(beverage, 0);

        int totalPrice = 0;
        int discountPrice = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<B ; i++) {
            bugger[i] = Integer.parseInt(st.nextToken());
            totalPrice += bugger[i];
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<C ; i++) {
            side[i] = Integer.parseInt(st.nextToken());
            totalPrice += side[i];
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<D ; i++) {
            beverage[i] = Integer.parseInt(st.nextToken());
            totalPrice += beverage[i];
        }

        Arrays.sort(bugger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(beverage, Collections.reverseOrder());

        int tmp = 0;
        for(int i=0 ; i<minCnt ; i++) {
            tmp += bugger[i];
            tmp += side[i];
            tmp += beverage[i];
        }
        discountPrice += (int)((totalPrice - tmp) + tmp * 0.9);

        System.out.println(totalPrice);
        System.out.println(discountPrice);

        bf.close();
        System.exit(0);
    }
}