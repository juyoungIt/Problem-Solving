// BOJ - 1302
// Problem Sheet - https://www.acmicpc.net/problem/1302

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> saleCount = new HashMap<>(); // 각 책별 판매횟수 저장

        int n = Integer.parseInt(bf.readLine()); // 판매된 책의 수

        for(int i=0 ; i<n ; i++) {
            String book = bf.readLine();
            if(!saleCount.containsKey(book)) saleCount.put(book, 1);
            else saleCount.put(book, saleCount.get(book) + 1);
        }

        List<String> bookNames = new ArrayList<>(saleCount.keySet());
        bookNames.sort((b1, b2) -> (saleCount.get(b2).compareTo(saleCount.get(b1))));

        List<String> result = new ArrayList<>();
        int max = saleCount.get(bookNames.get(0));
        for(String name : bookNames)
            if(saleCount.get(name) == max)
                result.add(name);

        Collections.sort(result);
        System.out.println(result.get(0));

        bf.close();
        System.exit(0);
    }
}