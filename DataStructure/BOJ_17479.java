// BOJ - 17479
// Problem Sheet - https://www.acmicpc.net/problem/17479

import java.util.*;
import java.io.*;

public class Main {

    private static final String VALID_ORDER = "Okay";
    private static final String INVALID_ORDER = "No";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int numberOfCommonMenus = Integer.parseInt(st.nextToken());
        int numberOfSpecialMenus = Integer.parseInt(st.nextToken());
        int numberOfServiceMenus = Integer.parseInt(st.nextToken());

        Map<String, Integer> commonMenus = new HashMap<>();
        for(int i=0 ; i<numberOfCommonMenus ; i++) {
            st = new StringTokenizer(bf.readLine());
            commonMenus.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        Map<String, Integer> specialMenus = new HashMap<>();
        for(int i=0 ; i<numberOfSpecialMenus ; i++) {
            st = new StringTokenizer(bf.readLine());
            specialMenus.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        Set<String> serviceMenus = new HashSet<>();
        for(int i=0 ; i<numberOfServiceMenus ; i++) {
            serviceMenus.add(bf.readLine());
        }

        int numberOfOrders = Integer.parseInt(bf.readLine());
        long[][] orderInfos = new long[3][2];
        for(int i=0 ; i<numberOfOrders ; i++) {
            String order = bf.readLine();
            if(commonMenus.containsKey(order)) {
                orderInfos[0][0]++;
                orderInfos[0][1] += commonMenus.get(order);
            } else if(specialMenus.containsKey(order)) {
                orderInfos[1][0]++;
                orderInfos[1][1] += specialMenus.get(order);
            } else if(serviceMenus.contains(order)) {
                orderInfos[2][0]++;
            } else {
                throw new IllegalArgumentException("Invalid Order Values...");
            }
        }

        System.out.println((isValidOrder(orderInfos)) ? VALID_ORDER : INVALID_ORDER);

        bf.close();
        System.exit(0);
    }

    static boolean isValidOrder(long[][] orderInfos) {
        if(orderInfos[0][0] > 0 && orderInfos[2][0] > 0) {
            return isAbleOrderSpecialMenus(orderInfos[0][1])
                    && isAbleOrderServiceMenus(orderInfos[0][1], orderInfos[1][1])
                    && isValidServiceMenuOrder((int) orderInfos[2][0]);
        } else if(orderInfos[0][0] > 0 && orderInfos[1][0] > 0) {
            return isAbleOrderSpecialMenus(orderInfos[0][1]);
        } else {
            return orderInfos[0][0] > 0;
        }
    }

    static boolean isAbleOrderSpecialMenus(long commonMenuSales) {
        return commonMenuSales >= 20000;
    }

    static boolean isAbleOrderServiceMenus(long commonMenuSales, long specialMenuSales) {
        return commonMenuSales + specialMenuSales >= 50000;
    }

    static boolean isValidServiceMenuOrder(int numberOfSpecialMenus) {
        return numberOfSpecialMenus <= 1;
    }
}