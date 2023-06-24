// BOJ - 1302
// Problem Sheet - https://www.acmicpc.net/problem/1302

import java.util.*;
import java.io.*;

public class Main {

    static class Book {
        private final String name;
        private final int soldCount;

        public Book(String name, int soldCount) {
            this.name = name;
            this.soldCount = soldCount;
        }

        public String getName() { return this.name; }
        public int getSoldCount() { return this.soldCount; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfSoledBooks = Integer.parseInt(bf.readLine());
        Map<String, Integer> soldCountMapper = new HashMap<>();
        for(int i=0 ; i<numberOfSoledBooks ; i++) {
            String bookName = bf.readLine();
            if(!soldCountMapper.containsKey(bookName)) {
                soldCountMapper.put(bookName, 0);
            }
            soldCountMapper.put(bookName, soldCountMapper.get(bookName) + 1);
        }

        Book[] books = new Book[soldCountMapper.size()];
        int curSize = 0;
        for(Map.Entry<String, Integer> entry : soldCountMapper.entrySet()) {
            books[curSize++] = new Book(entry.getKey(), entry.getValue());
        }

        Arrays.sort(books, (o1, o2) -> {
            if(o1.getSoldCount() == o2.getSoldCount()) {
                return o2.getName().compareTo(o1.getName());
            }
            return o1.getSoldCount() - o2.getSoldCount();
        });

        sb.append(books[soldCountMapper.size()-1].getName()).append("\n");
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}