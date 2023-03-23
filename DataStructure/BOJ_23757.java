// BOJ - 23757
// Problem Sheet - https://www.acmicpc.net/problem/23757

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean isAvailable = true;

        int numberOfGift = Integer.parseInt(st.nextToken());
        int numberOfChildren = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> gifts = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfGift ; i++) {
            gifts.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfChildren ; i++) {
            int giftCount = Integer.parseInt(st.nextToken());
            if(!gifts.isEmpty() && gifts.peek() >= giftCount) {
                gifts.add(gifts.poll() - giftCount);
            } else {
                isAvailable = false;
                break;
            }
        }

        System.out.println((isAvailable) ? 1 : 0);

        bf.close();
        System.exit(0);
    }
}