// BOJ - 18706
// Problem Sheet - https://www.acmicpc.net/problem/18706

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, Integer> resultMapper = new LinkedHashMap<>();
        Map<String, Integer> indexMapper = new HashMap<>();
        indexMapper.put("small", 0);
        indexMapper.put("medium", 1);
        indexMapper.put("large", 2);

        Map<String, List<Integer>> priceMapper = new HashMap<>();
        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            st = new StringTokenizer(bf.readLine());
            int numberOfCoffees = Integer.parseInt(st.nextToken());
            int numberOfPersons = Integer.parseInt(st.nextToken());
            int deliveryFee = 100 / numberOfPersons;
            for(int j=0 ; j<numberOfCoffees ; j++) {
                st = new StringTokenizer(bf.readLine());
                String coffeeName = st.nextToken();
                priceMapper.put(coffeeName, new ArrayList<>(3));
                for(int k=0 ; k<3 ; k++) {
                    priceMapper.get(coffeeName).add(Integer.parseInt(st.nextToken()));
                }
            }

            for(int j=0 ; j<numberOfPersons ; j++) {
                String[] orders = bf.readLine().split(" ");
                int price = getTotalPrice(
                        priceMapper.get(orders[2]).get(indexMapper.get(orders[1])),
                        deliveryFee
                );
                resultMapper.put(orders[0], price);
            }

            for(Map.Entry<String, Integer> entry : resultMapper.entrySet()) {
                sb.append(entry.getKey())
                        .append(" ")
                        .append(entry.getValue())
                        .append("\n");
            }
            resultMapper.clear();
            priceMapper.clear();
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getTotalPrice(int orderFee, int deliveryFee) {
        int realTotalPrice = orderFee + deliveryFee;
        if(realTotalPrice % 5 == 1) {
            return realTotalPrice - 1;
        } else if(realTotalPrice % 5 == 4) {
            return realTotalPrice + 1;
        } else {
            return realTotalPrice;
        }
    }
}