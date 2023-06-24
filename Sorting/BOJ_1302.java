// BOJ - 1302
// Problem Sheet - https://www.acmicpc.net/problem/1302

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSoldBooks = Integer.parseInt(bf.readLine());
        String[] books = new String[numberOfSoldBooks];
        for(int i=0 ; i<numberOfSoldBooks ; i++) {
            books[i] = bf.readLine();
        }
        Arrays.sort(books);

        String maxTitle = books[0];
        int maxCount = 1;
        int currentCount = 1;
        for(int i=1 ; i<books.length ; i++) {
            if(!books[i].equals(books[i-1])) {
                currentCount = 0;
            }
            currentCount++;
            if(maxCount < currentCount) {
                maxCount = currentCount;
                maxTitle = books[i];
            }
        }

        System.out.println(maxTitle);

        bf.close();
        System.exit(0);
    }
}