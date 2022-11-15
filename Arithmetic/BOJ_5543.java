// BOJ - 5543
// Problem Sheet - https://www.acmicpc.net/problem/5543

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] buggers = new int[3]; // 햄버거의 가격
        int[] beverages = new int[2]; // 음료의 가격
        int answer = Integer.MAX_VALUE;

        // 햄버거와 음료정보 입력
        for(int i=0 ; i<5 ; i++) {
            if(i<3) buggers[i] = Integer.parseInt(bf.readLine());
            else beverages[i-3] = Integer.parseInt(bf.readLine());
        }

        // 가장 저렴한 세트메뉴의 가격을 구함
        for(int bugger : buggers) {
            for(int beverage : beverages) {
                int price = bugger + beverage - 50;
                if(answer > price)
                    answer = price;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}